package guide.springboot.sample.todos.springdata;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class ToDoEntity {

    @Id
    private String id;
    private String details;
    private String status;

    protected ToDoEntity(){
    }

    ToDoEntity(final String id, final String details, final String status){
        this.id = id;
        this.details= details;
        this.status = status;
    }

    String getId(){
        return id;
    }
    String getDetails(){
        return details;
    }
    String getStatus(){
        return status;
    }
}
