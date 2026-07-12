package Spring.controller;

import Spring.DAO.TicketDAO;
import Spring.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class TicketController {

    private final TicketDAO ticketDAO;

    @Autowired
    public TicketController(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @GetMapping("/tickets")
    public String tickets(Model model) {
        model.addAttribute("tickets", ticketDAO.index());
        return "index";
    }

    @GetMapping("/add")
    public String addTicket(@ModelAttribute("ticket") Ticket ticket) {
        return "add";
    }

    @PostMapping()
    public String addTicket(@ModelAttribute("ticket") @Valid Ticket ticket, BindingResult result) {
        if (result.hasErrors()) {
            System.err.println(result.getAllErrors().toString());
            return "add";
        }

        ticketDAO.addTicket(ticket);
        return "redirect:/tickets";
    }
}
