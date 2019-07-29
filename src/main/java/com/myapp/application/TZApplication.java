package com.myapp.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myapp.application.entity.Application;
import com.myapp.application.entity.Ticket;
import com.myapp.application.repository.ApplicationRepository;
import com.myapp.application.repository.TicketRepository;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class TZApplication {
	public static void main(String[] args) {
		SpringApplication.run(TZApplication.class, args);
		System.out.println("Application started");
	}
	
	@Bean
	public CommandLineRunner providesCommandLineRunner(
        final ApplicationRepository applicationRepository,
        final TicketRepository ticketRepository) {
	    
	    return args -> {
	        
	        log.info("Impl" + applicationRepository.getClass().getCanonicalName());
	        log.info("Impl" + ticketRepository.getClass().getCanonicalName());
	        
	        Application app1 = Application.builder().name("Trackzilla").build();
	        Application app2 = Application.builder().name("SIM").build();
	        
	        applicationRepository.save(app1);
	        applicationRepository.save(app2);

	        ticketRepository.save(Ticket.builder().owner("mbbhalla").description("TZ ticket").application(app1).build());
	        ticketRepository.save(Ticket.builder().owner("mbbhalla").description("SIM ticket").application(app2).build());
	        
	    };
	}
}


