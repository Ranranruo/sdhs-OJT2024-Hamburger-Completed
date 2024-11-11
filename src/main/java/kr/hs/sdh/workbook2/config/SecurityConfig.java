package kr.hs.sdh.workbook2.config;

import kr.hs.sdh.workbook2.entity.Member;
import kr.hs.sdh.workbook2.entity.Role;
import kr.hs.sdh.workbook2.provider.MemberAuthenticationProvider;
import kr.hs.sdh.workbook2.service.MemberService;
import kr.hs.sdh.workbook2.service.RoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

// 설정파일
@Configuration
public class SecurityConfig {

    private final MemberService memberService;
    private final RoleService roleService;

    public SecurityConfig(MemberService memberService, RoleService roleService) {
        this.memberService = memberService;
        this.roleService = roleService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        return http
                .authenticationProvider(this.authenticationProvider())
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/login").anonymous()
                        .requestMatchers(
                                "/styles/**",
                                "/scripts/**",
                                "/images/**",
                                "/fonts/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/lotteria-example")
                        .failureHandler((request, response, exception) -> {
                            exception.printStackTrace();
                            response.sendRedirect("/login?error");
                        })
                )
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.contentEquals(rawPassword);
            }
        };
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        MemberAuthenticationProvider memberAuthenticationProvider = new MemberAuthenticationProvider();
        memberAuthenticationProvider.setUserDetailsService(id -> {
            final Member member = this.memberService.findMemberById(id);

            if(member == null || id.isEmpty())
                throw new UsernameNotFoundException("%s 아이디를 가진 사용자를 찾을 수 없습니다.".formatted(id));

            Set<Role> roles = this.roleService.getRoles(id);
            String[] roleCodes = roles.stream()
                    .map(Role::getCode)
                    .toArray(String[]::new);

            return User
                    .withUsername(member.getId())
                    .password(member.getPassword())
                    .roles(roleCodes)
                    .build();
        });
        memberAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return memberAuthenticationProvider;
    }

    @Bean("les")
    String getName() {
        return "은상이";
    }
}
