package guide.springboot.sample.controller;

import guide.springboot.sample.todos.ToDo;

import static java.util.Objects.requireNonNull;

class ToDoIdentifierJson {
    private final String id;
    //private final String details;
    //private final String status;

    ToDoIdentifierJson(final String id){
        this.id = requireNonNull(id);
        //this.details = todo.getDetails();
        //this.status = todo.getStatus();
    }

    public String getId(){
        return id;
    }
    //public String getDetails(){return details;}
    //public String getStatus(){return status;}
}
