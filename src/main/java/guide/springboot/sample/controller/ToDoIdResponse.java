package guide.springboot.sample.controller;

import static java.util.Objects.requireNonNull;

public class ToDoIdResponse {
    private final String id;

    ToDoIdResponse(final String id){
        this.id = requireNonNull(id);
    }

    public String getId(){
        return id;
    }
}
