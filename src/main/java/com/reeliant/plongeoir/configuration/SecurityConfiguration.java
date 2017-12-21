package com.reeliant.plongeoir.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    @Configuration
    @Order(1)
    public static class AdminConfigurationAdpater extends WebSecurityConfigurerAdapter {
        public AdminConfigurationAdpater() {
            super();
        }

        protected void configure(HttpSecurity http) throws Exception  {
            http
                    .csrf().disable()
                    .authorizeRequests()

                    .antMatchers("/", "/ressources/**").permitAll()

                    .antMatchers("/admin/**").authenticated()

                    .and()
                    .formLogin()
                    .loginPage("/loginAdmin")
                    .defaultSuccessUrl("/adminPage")
                    .usernameParameter("email")
                    .permitAll()
                    .and()
                    .logout()
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

        }
    }

}
