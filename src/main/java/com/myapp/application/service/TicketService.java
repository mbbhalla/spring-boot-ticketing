package com.myapp.application.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.application.entity.Ticket;
import com.myapp.application.repository.TicketRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class TicketService {

    private TicketRepository ticketRepository;
    
    public List<Ticket> listTickets() {
        
        return StreamSupport.stream(this.ticketRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }
    
}
