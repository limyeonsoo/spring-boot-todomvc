package guide.springboot.sample.todos;

import guide.springboot.sample.lang.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

public class ToDo {
    private final UUID id;
    private final String details;
    private final ToDoStatus status;

    public ToDo(final UUID id, final String details, final ToDoStatus status){
       // var uuidGenerator = new UuidGenerator();

        //this.identifier = uuidGenerator.generateUuidString();
        this.id = id;
        this.details = details;
        this.status = status;
    }

//    public ToDoIdentifier getIdentifier(){
//        return identifier;
//    }
//    public String getTitle(){
//        return title;
//    }
//    public String getIdentifier(){
//        return this.identifier;
//    }
    public UUID getId(){

        return this.id;
    }
    public String getDetails(){

        return this.details;
    }
    public ToDoStatus getStatus(){

        return this.status;
    }

//    @Override
//    public boolean equals(Object o){
//        if(this == o) return true;
//        if(o == null | getClass() != o.getClass()) return false;
//        final ToDo todo = (ToDo) o;
//        return identifier.equals(todo.identifier) && title.equals(todo.title);
//    }
//
//    @Override
//    public int hashCode(){
//        return Objects.hash(identifier, title);
//    }
}
