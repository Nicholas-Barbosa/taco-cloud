package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class IngredientClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(IngredientClientApplication.class, args);
	}
}
