package kr.hs.sdh.workbook2.provider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

public final class MemberAuthenticationProvider extends DaoAuthenticationProvider {
    public MemberAuthenticationProvider() {
        super.setHideUserNotFoundExceptions(false);
    }
}
