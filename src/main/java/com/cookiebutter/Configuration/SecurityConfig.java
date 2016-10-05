package com.cookiebutter.Configuration;

import com.cookiebutter.Services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by luis on 04/10/16.
 */
@Configurable
@EnableGlobalMethodSecurity
@EnableWebMvc
@ComponentScan(basePackageClasses = CustomUserDetailService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .and()
                .formLogin()
                    .loginPage("/user/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .failureUrl("/user/login?error")
                    .defaultSuccessUrl("/someothersite")
                    .permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/user/login?logout")
                    .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/auth_required")
                .and()
                .csrf();
    }

    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }
}
