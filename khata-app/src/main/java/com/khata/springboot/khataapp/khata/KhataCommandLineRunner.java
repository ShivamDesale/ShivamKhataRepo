package com.khata.springboot.khataapp.khata;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KhataCommandLineRunner implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private KhataRepository repository;
	
	public KhataCommandLineRunner(KhataRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("command line runner");
//		logger.info(Arrays.toString(args));

//		repository.save(new Khata(0, "Shibhudhala0"));
//		repository.save(new Khata(, "Shibhudhala2"));
//		
//		List<Khata> users1 = repository.findAll();
//		List<UserDetails> users = repository.findByRole("Admin");
//		List<Khata> users = repository.findByName("Shibhudhala1");
		
//		users.forEach(user -> logger.info(user.toString()));
	}
}
