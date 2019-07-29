package com.myapp.application.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.application.entity.Application;
import com.myapp.application.entity.Ticket;
import com.myapp.application.service.ApplicationService;
import com.myapp.application.service.TicketService;

import lombok.AllArgsConstructor;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class RestController {

    private ApplicationService applicationService;
    
    private TicketService ticketService;
    
    @RequestMapping(path = "/api/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Ticket> tickets() {

        return this.ticketService.listTickets();
    }
    
    @RequestMapping(path = "/api/applications", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Application> applications() {
        
        return this.applicationService.listApplications();
    }
}
