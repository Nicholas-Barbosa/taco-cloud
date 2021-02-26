package tacos.data.jpa;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tacos.data.UserCrudService;
import tacos.domain.User;
import tacos.repositry.jpa.UserJpaRepository;

@Service
public class UserJpaCrudService implements UserCrudService {

	private final UserJpaRepository userRepo;

	public UserJpaCrudService(UserJpaRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public User save(User t) {
		// TODO Auto-generated method stub
		return userRepo.save(t);
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return userRepo.findAll(page);
	}

}
