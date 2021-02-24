package tacos.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tacos.repositry.jpa.UserJpaRepository;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

	private final UserJpaRepository userRepo;

	public UserRepositoryUserDetailsService(UserJpaRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		return userRepo.getByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found"));
	}

}
