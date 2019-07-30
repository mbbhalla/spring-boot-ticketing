package com.myapp.application.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.application.entity.Application;
import com.myapp.application.entity.Ticket;
import com.myapp.application.service.ApplicationService;
import com.myapp.application.service.TicketService;

import lombok.AllArgsConstructor;
import lombok.val;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class RestController {

    private ApplicationService applicationService;
    
    private TicketService ticketService;
    
    @RequestMapping(path = "/api/tickets",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> tickets() {

        return new ResponseEntity<>(ticketService.listTickets(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/api/applications", 
        method = RequestMethod.GET,    
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Application>> applications() {
        
        return new ResponseEntity<>(this.applicationService.listApplications(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/api/ticket/{id}", 
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> ticketById(
        @PathVariable("id") final Long id) {
        
        val response = this.ticketService.getTicketById(id);
        
        return response.isPresent() 
            ? new ResponseEntity<>(response.get(), HttpStatus.OK) 
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/api/application/{id}", 
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Application> applicationById(
        @PathVariable("id") final Long id) {
        
        val response = this.applicationService.getApplicationById(id);
        
        return response.isPresent() 
            ? new ResponseEntity<>(response.get(), HttpStatus.OK) 
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
