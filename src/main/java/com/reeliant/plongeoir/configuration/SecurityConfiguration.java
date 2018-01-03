package com.reeliant.plongeoir.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Configuration
    @Order(1)
    public static class AdminConfigurationAdpater extends WebSecurityConfigurerAdapter {
        public AdminConfigurationAdpater() {
            super();
        }

        protected void configure(HttpSecurity http) throws Exception  {
            http
                    .antMatcher("/bo/**")
                    .authorizeRequests()
                        .anyRequest().authenticated()
                        .and()
                    .formLogin()
                        .loginPage("/bo/login")
                        .defaultSuccessUrl("/bo/home")
                        .permitAll()
                        .and()
                    .logout()
                        .logoutUrl("/bo/logout")
                        .permitAll();
        }
    }

    @Configuration
    @Order(2)
    public static class UserConfigurationAdpater extends WebSecurityConfigurerAdapter {
        public UserConfigurationAdpater() {
            super();
        }

        protected void configure(HttpSecurity http) throws Exception  {
            http
                    .authorizeRequests()
                        .antMatchers("/css/**").permitAll()
                        .antMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                        .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/home")
                        .permitAll()
                        .and()
                    .logout()
                        .logoutUrl("/logout")
                        .permitAll();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("user")
                    .password("password")
                    .roles("USER");
        }
    }

}
