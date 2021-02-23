package tacos.data;

import java.util.Optional;

public interface CrudService<T, ID> {

	T save(T t);

	Iterable<T> findAll();

	Optional<T> findById(ID id);
}
