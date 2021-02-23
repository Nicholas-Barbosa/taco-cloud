package tacos.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tacos.domain.Ingredient;
import tacos.domain.Ingredient.Type;
import tacos.repositry.jdbc.IngredientRepository;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Iterable<Ingredient> findAll() {
		return jdbcTemplate.query("SELECT id,name,type from Ingredient", this::mapRowToIngredient);
	}

	@Override
	public Optional<Ingredient> findById(String id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT id,name,type FROM Ingredient where id =?",
				this::mapRowToIngredient, id));
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("INSERT INTO Ingredient(id,name,type) values(?,?,?)", ingredient.getId(),
				ingredient.getName(), ingredient.getType());
		return ingredient;
	}

	private Ingredient mapRowToIngredient(ResultSet rs, int n) throws SQLException {
		return new Ingredient(rs.getString("id"), rs.getString("name"), Type.valueOf(rs.getString("type")));
	}
}
