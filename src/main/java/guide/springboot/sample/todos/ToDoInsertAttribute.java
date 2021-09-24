package guide.springboot.sample.todos;

import static java.util.Objects.requireNonNull;

public class ToDoInsertAttribute {
    private final String details;

    public ToDoInsertAttribute(final String details){
        this.details = requireNonNull(details);
    }
    public String getDetails(){
        return details;
    }

}
