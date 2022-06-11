package com.trackerlora.backend;

import com.trackerlora.backend.security.JWTAuthorizationFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class SecurityConfiguration {


        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable()
            .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/auth/register", "/auth/login" ).permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();

            return http.build();
        }
	}
}

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.client.RestTemplate;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @SpringBootApplication
// public class BackendApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(BackendApplication.class, args);
// 	}

//     @Bean
// 	public WebMvcConfigurer corsConfigurer() {
// 		return new WebMvcConfigurer() {
// 			@Override
// 			public void addCorsMappings(CorsRegistry registry) {
// 				registry.addMapping("/**").allowedOrigins("https://trackerlora.lopezcarrillo.com");
//                 registry.addMapping("/**").allowedOrigins("http://localhost:4200");
// 			}
// 		};
// 	}
//     @Bean
//     public RestTemplate restTemplate() {
//         return new RestTemplate();
//     }

// }
