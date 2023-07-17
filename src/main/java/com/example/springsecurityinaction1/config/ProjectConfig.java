package com.example.springsecurityinaction1.config;

import com.example.springsecurityinaction1.auth.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 책에 나오는 WebSecurityConfigurerAdapter는 deprecated 됐다.
        // 공식문서의 설명에 따라 filterChain을 만들어서 동일하게 구현할 수 있다.

        // 모든 요청에 인증 필요
        http.authorizeRequests((authz)
                        -> authz.anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
