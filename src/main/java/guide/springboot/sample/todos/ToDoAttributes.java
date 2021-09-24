package guide.springboot.sample.todos;

import static java.util.Objects.requireNonNull;

public class ToDoAttributes {
    private final String details;
    private final ToDoStatus status;

    public ToDoAttributes(){
        this.details = null;
        this.status = null;
    };

    public ToDoAttributes(final String details, final ToDoStatus status){
        this.details = requireNonNull(details);
        this.status = requireNonNull(status);
    }

    public String getDetails(){
        return details;
    }
    public ToDoStatus getStatus() { return status; }
}

