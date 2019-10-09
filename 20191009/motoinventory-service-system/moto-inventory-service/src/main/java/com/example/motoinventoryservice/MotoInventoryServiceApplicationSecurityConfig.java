package com.example.motoinventoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MotoInventoryServiceApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    // Properties
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authenticationManagerBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
                .passwordEncoder(encoder);
    }

    // INPUT URL's to Protect and permissions
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity.authorizeRequests()
                .mvcMatchers("/login").authenticated()
                .mvcMatchers(HttpMethod.GET, "/vehicle/{vin}").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.GET,"/motorcycles/{motoId}").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT, "/motorcycles/{motoId}").hasAuthority("ROLE_SALES_PERSON")
                .mvcMatchers(HttpMethod.POST, "/motorcycles").hasAuthority("ROLE_SALES_MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/motorcycles/{motoId}").hasAuthority("ROLE_SALES_MANAGER");

        // Logout Procedures
        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        // CSRF Tokens
        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
