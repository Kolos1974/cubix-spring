package hu.cubix.logistic.kolos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.cubix.logistic.kolos.service.InitDbService;

@SpringBootApplication
public class LogisticApplication implements CommandLineRunner {
	
	@Autowired
	InitDbService initDbService;

	public static void main(String[] args) {
		SpringApplication.run(LogisticApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Logistic application:");

	
		
		
		
		initDbService.initDb();
	}
}
