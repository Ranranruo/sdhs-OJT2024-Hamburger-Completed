package kr.hs.sdh.workbook2.config;

import kr.hs.sdh.workbook2.entity.Member;
import kr.hs.sdh.workbook2.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 설정파일
@Configuration
public class SecurityConfig {

    private final MemberService memberService;

    public SecurityConfig(MemberService memberService) {
        this.memberService = memberService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
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
                )
                .userDetailsService(id -> {
                    final Member member = this.memberService.findMemberById(id);
                    return User
                            .withUsername(member.getId())
                            .password(member.getPassword())
                            .build();
                })
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

    @Bean("les")
    String getName() {
        return "은상이";
    }
}
