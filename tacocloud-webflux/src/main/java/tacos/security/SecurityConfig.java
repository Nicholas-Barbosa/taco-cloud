package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http.authorizeExchange().pathMatchers("/authen").authenticated().anyExchange().permitAll().and().build();
	}

	@Bean
	public ReactiveUserDetailsService reactiveUserDetailsService() {
		System.out.println("reacri");
		return new ReactiveUserDetailsService() {

			@Override
			public Mono<UserDetails> findByUsername(String username) {
				System.out.println("findByUsername " + username);
				return Mono
						.just(User.withUsername("nicholas").password(enconder().encode("123")).roles("USER").build());
			}
		};
	}

	@Bean
	public PasswordEncoder enconder() {
		return new BCryptPasswordEncoder();
	}
}
