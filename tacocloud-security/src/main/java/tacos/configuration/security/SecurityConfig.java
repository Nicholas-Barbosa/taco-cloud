package tacos.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public SecurityConfig(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public PasswordEncoder enconder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().antMatchers("/design/**", "/orders/**")
				.hasRole("USER").antMatchers("/login").access("permitAll").antMatchers("/", "/**")
				.access("T(java.time.LocalDate).now().getYear()==2021").and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/design").usernameParameter("user").passwordParameter("pwd").and().logout()
				.logoutSuccessUrl("/").and().csrf().ignoringAntMatchers("/h2-console/**", "/api/datarest/**").and()
				.headers().frameOptions().sameOrigin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub

		auth.userDetailsService(userDetailsService).passwordEncoder(this.enconder());
		/*
		 * In-memory
		 * 
		 * auth.inMemoryAuthentication().withUser("buzz").password("infinity")
		 * .authorities("ROLE_USER").and().withUser("woody").password("bullseye").
		 * authorities("ROLE_USER").and()
		 * .withUser("nicholas").password("123").authorities("ROLE_USER");
		 */

		/*
		 * Jdbc authentication exmple
		 * 
		 * Overriding default queries from jdbcAuthentication...
		 * 
		 * auth.jdbcAuthentication().dataSource(dataSource)
		 * .usersByUsernameQuery("SELECT username,password,enabled from Users where username = ?"
		 * )
		 * .authoritiesByUsernameQuery("select username,authority from UserAuthorities where username =?"
		 * ) .passwordEncoder(new Pbkdf2PasswordEncoder("53cr3t"));
		 */

		/*
		 * LDAP-based
		 * 
		 * auth.ldapAuthentication().userSearchBase("ou=people").userSearchFilter(
		 * "(uid={0})").groupSearchBase("ou=groups")
		 * .groupSearchFilter("member={0}").passwordCompare().passwordEncoder(new
		 * BCryptPasswordEncoder()) .passwordAttribute("passcode");
		 *
		 * Remote LDAP server
		 * 
		 * auth.ldapAuthentication().userSearchBase("ou=people").userSearchFilter(
		 * "(uid={0})").groupSearchBase("ou=groups")
		 * .groupSearchFilter("member={0}").passwordCompare().passwordEncoder(new
		 * BCryptPasswordEncoder()) .passwordAttribute("passcode").contextSource().url(
		 * "ldap://tacocloud.com:389/dc=tacocloud,dc=com");
		 * 
		 * Embeded LDAP server
		 * 
		 * auth.ldapAuthentication().userSearchBase("ou=people").userSearchFilter(
		 * "(uid={0})").groupSearchBase("ou=groups")
		 * .groupSearchFilter("member={0}").passwordCompare().passwordEncoder(new
		 * BCryptPasswordEncoder()) .passwordAttribute("passcode").contextSource().root(
		 * "dc=tacocloud,dc=com").ldif("classpath:users.ldif");
		 *
		 */

	}
}
