package guide.springboot.sample.todos;

public class ToDoAttributes {
    private final String details;

    public ToDoAttributes(final String details){
        this.details = details;
    }

    public String getDetails(){
        return details;
    }
}
