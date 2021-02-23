package tacos.repositry.jdbc;

import tacos.domain.Taco;

public interface TacoRepository {

	Taco save(Taco taco);
}
