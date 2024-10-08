package com.fincatto;

import com.fincatto.views.DFViewLogin;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class DFApplicationSecurity extends VaadinWebSecurity {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Delegating the responsibility of general configurations of http security to the super class.
        // It's configuring the followings: Vaadin's CSRF protection by ignoring framework's internal requests,
        // default request cache, ignoring public views annotated with @AnonymousAllowed,
        // restricting access to other views/endpoints, and enabling NavigationAccessControl authorization.
        // You can add any possible extra configurations of your own here (the following is just an example):

        // http.rememberMe().alwaysRemember(false);

        // Configure your static resources with public access before calling super.configure(HttpSecurity) as it adds final anyRequest matcher
        http.authorizeHttpRequests(auth -> auth.requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll());
        http.authorizeHttpRequests(auth -> auth.requestMatchers(new AntPathRequestMatcher("/icons/**")).permitAll());
        super.configure(http);

        // This is important to register your login view to the navigation access control mechanism:
        setLoginView(http, DFViewLogin.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * Demo UserDetailsManager which only provides two hardcoded  in memory users and their roles.
     * NOTE: This shouldn't be used in real world applications.
     */
    @Bean
    public UserDetailsManager userDetailsService() {
        UserDetails user =
                User.withUsername("user")
                        .password("{noop}user")
                        .roles(DFApplicationRoles.ROLE_USER)
                        .build();
        UserDetails admin =
                User.withUsername("admin")
                        .password("{noop}admin")
                        .roles(DFApplicationRoles.ROLE_ADMIN, DFApplicationRoles.ROLE_USER)
                        .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
