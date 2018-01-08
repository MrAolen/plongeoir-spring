package com.reeliant.plongeoir.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Configuration
    @Order(1000)
    public static class AdminConfigurationAdpater extends WebSecurityConfigurerAdapter {
        public AdminConfigurationAdpater() {
            super();
        }

        @Autowired
        private UserDetailsService userDetailsService;

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

        protected void configure(HttpSecurity http) throws Exception  {
            http
                    .csrf().disable()
                    .antMatcher("/bo/**")
                        .authorizeRequests()
                        .anyRequest()
                        .hasAuthority("ADMIN")
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

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        }
    }

    @Configuration
    @Order(2000)
    public static class UserConfigurationAdpater extends WebSecurityConfigurerAdapter {
        public UserConfigurationAdpater() {
            super();
        }

        @Autowired
        private UserDetailsService userDetailsService;

        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

        protected void configure(HttpSecurity http) throws Exception  {
            http
                    .csrf().disable()
                    .authorizeRequests().antMatchers("/css/**","/js/**","/hours","/rules","/home").permitAll()
                    .and()
                    .antMatcher("/**")
                        .authorizeRequests()
                        .anyRequest()
                        .hasAuthority("USER")
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
            auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        }
    }

}
