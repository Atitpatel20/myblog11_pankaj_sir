package com.myblog.myblog11.config;

import com.myblog.myblog11.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF for simplicity
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/**").permitAll() // Allow all users to access GET method
                .antMatchers(HttpMethod.POST, "/create-post").hasRole("ADMIN") // Only admins can access POST method for creating a post
                .antMatchers(HttpMethod.POST,"/api/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // Use HTTP Basic Authentication
    }
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails user1 = User.builder().username("atit").password(passwordEncoder()
//                .encode("password")).roles("USER").build();
//        UserDetails user2 = User.builder().username("admin").password(passwordEncoder()
//                .encode("admin")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
    @Bean // Expose AuthenticationManager as a bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    // it has built in method userDetailsService& it's used for supply username & pw comes from database
    protected void configure(AuthenticationManagerBuilder auth) throws
            Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}