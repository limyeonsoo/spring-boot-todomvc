package guide.springboot.sample.todos.springdata;


import guide.springboot.sample.todos.ToDoStatus;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "todos")
class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String details;
    private ToDoStatus status;

    protected ToDoEntity(){
    }

    ToDoEntity(final String details, final ToDoStatus status){
        this(null, details, status);
    }


    ToDoEntity(final UUID id, final String details, final ToDoStatus status){
        this.id = id;
        this.details= details;
        this.status = status;
    }


    UUID getId(){
        return id;
    }
    String getDetails(){
        return details;
    }
    ToDoStatus getStatus(){
        return status;
    }
}
