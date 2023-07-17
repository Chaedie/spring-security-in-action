package com.example.springsecurityinaction1.auth;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // Principal 인터페이스의 getName()메서드를 
        // Authentication에서 상속받는다.
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        // 이 조건은 일반적으로 UserDetailsService, PasswrodEncoder를 호출해서 
        // 사용자 이름과 암호를 테스트한다.
        // 인증 구현을 할 때 스프링 시큐리티 아키텍쳐 설계를 다르는 것이 좋다. 
        // -> (UserDetailsService, PasswordEncoder를 분리해서 사용하는 것이 좋다.)
        if ("john".equals(username) &&
                "12345".equals(password)) {

            return new UsernamePasswordAuthenticationToken(
                    username, password, Arrays.asList());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error in auth!!");
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
