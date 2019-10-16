/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Spring security for the endpoints exposed for user access.  You need:
 *                  "ROLE_STAFF" for PUT access
 *                  "ROLE_MANAGER" for POST access
 *                  "ROLE_ADMIN" for DELETE access
 *                  You do not need to be authenticated for GET access
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    /**
     * Authenticate a user from the database.
     */
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
        // Instantiate a new BCryptPasswordEncoder
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // Authenticate a user from the database
        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?")
                .passwordEncoder(encoder);

    }

    /**
     * Configuration for security for our application's endpoints
     * @param httpSecurity The security to be used in our configuration.
     * @throws Exception Thrown in the event of an error in our application.
     */
    public void configure(HttpSecurity httpSecurity) throws Exception {
        // Add basic Spring security to our application
        httpSecurity.httpBasic();

        // Require the following Authority access to the specific endpoints for our application
        httpSecurity.authorizeRequests()
                .mvcMatchers("/loggedin").authenticated()
                .mvcMatchers(HttpMethod.PUT, "/console").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT, "/game").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT, "/tshirt").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.POST, "/console").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/game").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/tshirt").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/order").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.DELETE, "/console/{id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/game/{id}").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/tshirt/{id}").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll();

        // Logout for our application
        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        // Remove csrf tokens from repo
        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }
}
