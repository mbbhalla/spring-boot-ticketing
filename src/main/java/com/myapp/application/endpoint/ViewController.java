package com.myapp.application.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myapp.application.service.ApplicationService;
import com.myapp.application.service.TicketService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ViewController {

    private ApplicationService applicationService;
    
    private TicketService ticketService;
    
    /*
     * add attributes to model which will be visible in view
     * return view name
     */
    @GetMapping("/tickets")
    public String tickets(
        final Model model) {

        model.addAttribute("tickets", this.ticketService.listTickets());
        return "tickets";
    }
    
    @GetMapping("/applications")
    public String applications(
        final Model model) {

        model.addAttribute("applications", this.applicationService.listApplications());
        return "applications";
    }
    
}
