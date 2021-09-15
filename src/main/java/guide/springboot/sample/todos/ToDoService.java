package guide.springboot.sample.todos;

import java.util.Optional;
import java.util.List;

public interface ToDoService {
    ToDoIdentifier insert(final ToDoAttributes attributes);

    // void delete(final ToDoIdentifier identifier);

    Optional<ToDo> select(final ToDoIdentifier identifier);

    List<ToDo> selectAll();
}
