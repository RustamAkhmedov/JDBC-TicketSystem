package Spring.DAO;

import Spring.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketDAO {

    private final JdbcTemplate jdbcTemplate;

    private static int currentID = 0;

    @Autowired
    public TicketDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Ticket> index() {
        List<Ticket> res = jdbcTemplate.query("SELECT * FROM tickets", new BeanPropertyRowMapper<>(Ticket.class));
        System.out.println(currentID);
        if(!res.isEmpty() )  {
            currentID = res.get(res.size() - 1).getID() + 1;
        }
        System.out.println (currentID);
        return res;
    }

    public void addTicket(Ticket ticket) {
        jdbcTemplate.update("Insert Into tickets Values (?, ?, ?, ?)",
                currentID,
                ticket.getMessage(),
                ticket.getDate(),
                ticket.getDescription());
    }


}
