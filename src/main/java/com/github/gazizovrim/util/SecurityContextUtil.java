package com.github.gazizovrim.util;

import com.github.gazizovrim.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by vladislav on 11.05.2015.
 */
public final class SecurityContextUtil {

    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return isNoAuth(authentication) ? null : (User) authentication.getPrincipal();
    }
    public static boolean isNoAuth(Authentication authentication) {
        return authentication == null || !(authentication instanceof UsernamePasswordAuthenticationToken);
    }
}
