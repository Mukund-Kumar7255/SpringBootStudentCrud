package studentcrud.example.student.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder()
    {

        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails adminuser= User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails normaluser= User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("user")
                .build();
        return new InMemoryUserDetailsManager(adminuser, normaluser);
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
