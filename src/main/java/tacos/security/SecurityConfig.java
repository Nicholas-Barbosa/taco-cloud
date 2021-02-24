package tacos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * In-memory
		 */
		auth.inMemoryAuthentication().withUser("buzz").password("infinity").authorities("ROLE_USER").and()
				.withUser("woody").password("bullseye").authorities("ROLE_USER").and().withUser("nicholas")
				.password("{noop}123").authorities("ROLE_USER");

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
