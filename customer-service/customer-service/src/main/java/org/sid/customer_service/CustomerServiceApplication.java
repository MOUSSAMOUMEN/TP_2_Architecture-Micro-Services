package org.sid.customer_service;

import org.sid.customer_service.entities.Customer;
import org.sid.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){

		restConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(new Customer(null,"Moussa","moumen.moussa@gmail.com"));
			customerRepository.save(new Customer(null,"Mohamed","moumen.mohamed@gmail.com"));
			customerRepository.save(new Customer(null,"Abdelah","moumen.abdelah@gmail.com"));
			customerRepository.save(new Customer(null,"Abderahman","moumen.abderahman@gmail.com"));
			customerRepository.save(new Customer(null,"Abdelkarim","moumen.abdelkarim@gmail.com"));

			customerRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});

		};
	}

}
