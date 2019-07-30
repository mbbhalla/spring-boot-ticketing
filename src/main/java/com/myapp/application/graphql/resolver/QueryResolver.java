package com.myapp.application.graphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.myapp.application.entity.Application;
import com.myapp.application.entity.Ticket;
import com.myapp.application.service.ApplicationService;
import com.myapp.application.service.TicketService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Component
@AllArgsConstructor(onConstructor_ = {@Autowired})
@Log
public class QueryResolver implements GraphQLQueryResolver {
    
    private final ApplicationService applicationService;
    
    private final TicketService ticketService;
    
    public List<Ticket> findAllTickets() {
        log.info(">>>>>>>>>>> findAllTickets");
        return this.ticketService.listTickets();
    }

    public List<Application> findAllApplications() {
        log.info(">>>>>>>>>>> findAllApplications");
        return this.applicationService.listApplications();
    }
    
    public Application applicationWithId(
        final Long id) {
        
        log.info(">>>>>>>>>>> applicationWithId " + id);
        return this.applicationService.getApplicationById(id)
            .orElseThrow(() -> new RuntimeException("not found"));
    }

    public Ticket ticketWithId(
        final Long id) {
           
        log.info(">>>>>>>>>>> ticketWithId " + id);
        return this.ticketService.getTicketById(id)
            .orElseThrow(() -> new RuntimeException("not found"));
    }
}
