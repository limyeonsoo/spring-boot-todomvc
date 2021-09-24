package guide.springboot.sample.todos;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

public interface ToDoService {
    UUID insert(final ToDoInsertAttribute attributes);

    String delete(final String targetId);

    // Optional<ToDo> select(final ToDoIdentifier identifier);
    Optional<ToDoAttributes> select(UUID id);
    // Optional: T type을 감싸는 wrapper

    List<ToDo> selectAll();

}
