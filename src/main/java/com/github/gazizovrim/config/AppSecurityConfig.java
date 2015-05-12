package com.github.gazizovrim.config;

import com.github.gazizovrim.security.impl.UserDetailsSecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by vladislav on 30.04.2015.
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackages = {"com.github.gazizovrim.security", "org.springframework.security"})
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsSecurityServiceImpl userDetailsSecurityService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsSecurityService)
                .passwordEncoder(getShaPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/app/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll().and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/index")
                    .permitAll();

        http.csrf().disable();

    }

    @Bean(name = "myAuthenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public ShaPasswordEncoder getShaPasswordEncoder() {
        return new ShaPasswordEncoder();
    }


}
