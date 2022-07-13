package com.example.bibliotek;

import com.example.bibliotek.documents.*;
import com.example.bibliotek.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@SpringBootApplication
public class BibliotekApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotekApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository,
										ProductRepository productRepository,
										ManufacturerRepository manufacturerRepository,
										ShopRepository shopRepository,
										ShopCartRepository shopCartRepository) {
		return args -> {

			User test = new User();
			test.setId(UUID.randomUUID());
			test.setFirstName("Test");
			test.setLastName("Testovich");
			test.setEmail("test@test.com");
			userRepository.save(test);

			Set<User> users = new HashSet<>();
			users.add(test);

			Shop shop = new Shop();
			shop.setId(UUID.randomUUID());
			shop.setName("Clavyanka");

			Set<Shop> shops = new HashSet<>();
			shops.add(shop);

			User test1 = new User();
			test1.setId(UUID.randomUUID());
			test1.setFirstName("Test1");
			test1.setLastName("Testovich1");
			test1.setEmail("test@test.com1");
			userRepository.save(test1);

			Manufacturer manufacturer = new Manufacturer();
			manufacturer.setId(UUID.randomUUID());
			manufacturer.setName("OLIVIA");
			manufacturer.setChief(test);
			manufacturerRepository.save(manufacturer);

			Product product = new Product();
			product.setId(UUID.randomUUID());
			product.setName("Moloko1");
			product.setPrice(BigDecimal.valueOf(122222212.22));
			product.setManufacturer(manufacturer);
			productRepository.save(product);

			Product product1 = new Product();
			product1.setId(UUID.randomUUID());
			product1.setName("Kolbdasa");
			product1.setCount(12);
			product1.setPrice(BigDecimal.valueOf(110.22));
			product1.setManufacturer(manufacturer);

			productRepository.save(product1);

		};
	}
}
