package hu.cubix.airport.config;

import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//		UserBuilder users = User.builder();
//		UserDetails user = users 
//				.username("user")
//				.password(passwordEncoder.encode("pass"))
//				.authorities("user")
//				.build();
//		
//		UserDetails admin = users 
//				.username("admin")
//				.password(passwordEncoder.encode("pass"))
//				.authorities("user", "admin")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user, admin);
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http
				/*
				.httpBasic(
						Customizer.withDefaults()
						)
				*/
				.csrf(
						csrf -> csrf.disable()
				)
/*				
				.authorizeHttpRequests(auth ->
						auth
								.requestMatchers(HttpMethod.POST, "/api/login").permitAll()
								.requestMatchers( HttpMethod.POST, "/api/addresses/**").hasAuthority("addressmanager")
								.requestMatchers( HttpMethod.PUT, "/api/addresses/**").hasAuthority("addressmanager")
								.requestMatchers("/api/addresses/**").authenticated()
								.requestMatchers("/api/sections/**").authenticated()
								.requestMatchers("/api/milestones/**").authenticated()
								.requestMatchers( "/api/transportPlans/**").hasAuthority("transportplanmanager")
				)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
*/				
				.build();
	}
	
}