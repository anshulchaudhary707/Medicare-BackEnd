package com.example.medicare;

import com.example.medicare.module.Role;
import com.example.medicare.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class MedicareApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepo;
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(MedicareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Role role1 = new Role(501,"ROLE_ADMIN");
			Role role2 = new Role(502,"ROLE_NORMAL");
			roleRepo.save(role1);
			roleRepo.save(role2);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
