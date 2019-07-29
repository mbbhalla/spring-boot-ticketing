package com.myapp.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TICKET_ID")
    private Long id;

    @Column(name = "TICKET_OWNER", length = 10)
    private String owner;
    
    @Column(name = "TICKET_DESCRIPTION")    
    private String description; 
    
    @ManyToOne
    @JoinColumn(name = "TICKET_APPLICATION_ID")
    private Application application;
}
