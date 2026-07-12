package Spring.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;

public class Ticket {

    private int id;

    @NotEmpty
    private String message;

    @NotEmpty
    @DateTimeFormat
    private String date;

    @NotEmpty
    private String description;

    public int getID(){
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
