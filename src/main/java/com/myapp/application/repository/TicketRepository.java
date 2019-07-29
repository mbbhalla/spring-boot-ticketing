package com.myapp.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.application.entity.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

}
