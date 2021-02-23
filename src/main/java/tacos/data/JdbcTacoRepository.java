package tacos.data;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import tacos.domain.Ingredient;
import tacos.domain.Taco;
import tacos.repositry.TacoRepository;

@Repository
public class JdbcTacoRepository implements TacoRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcTacoRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Taco save(Taco taco) {
		long tacoId = saveTacoInfo(taco);
		taco.setId(tacoId);
		taco.getIngredients().parallelStream().map(in -> {
			this.saveIngredientToTaco(in, tacoId);
			return "";
		}).collect(Collectors.counting());
		return taco;
	}

	private long saveTacoInfo(Taco taco) {
		taco.setCreatedAt(LocalDateTime.now());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement("insert into Taco (name, createdAt) values (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, taco.getName());
			ps.setObject(2, taco.getCreatedAt());
			return ps;
		}, keyHolder);
		return (long) keyHolder.getKey();
	}

	private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
		jdbcTemplate.update("insert into Taco_Ingredients (taco, ingredient) " + "values (?, ?)", tacoId,
				ingredient.getId());
	}

}
