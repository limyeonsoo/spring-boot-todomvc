package guide.springboot.sample.todos.springdata;


import guide.springboot.sample.todos.ToDoStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class ToDoEntity {

    @Id
    private String id;
    private String details;
    private ToDoStatus status;

    protected ToDoEntity(){
    }

    ToDoEntity(final String id, final String details, final ToDoStatus status){
        this.id = id;
        this.details= details;
        this.status = status;
    }

    ToDoEntity(final String details, final ToDoStatus status){
        this(null, details, status);
    }

    String getId(){
        return id;
    }
    String getDetails(){
        return details;
    }
    ToDoStatus getStatus(){
        return status;
    }
}
