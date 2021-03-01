package tacos.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tacos.domain.User;

public interface UserCrudService extends CrudService<User, Long> {

	Page<User> findAll(Pageable page);

	String encodePassword(String password);
}
