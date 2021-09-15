package guide.springboot.sample.todos;

import guide.springboot.sample.lang.UuidGenerator;

import java.util.Objects;

public class ToDo {
    private final ToDoIdentifier identifier;
    private final String details;
    private final String status;

    public ToDo(final ToDoIdentifier identifier, final String details, final String status){
        var uuidGenerator = new UuidGenerator();

        //this.identifier = uuidGenerator.generateUuidString();
        this.identifier = identifier;
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
    public String getId(){
        return this.identifier.getValue();
    }
    public String getDetails(){
        return this.details;
    }
    public String getStatus(){
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
