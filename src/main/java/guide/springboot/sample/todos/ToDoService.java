package guide.springboot.sample.todos;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

public interface ToDoService {
    List<ToDo> selectAll();

    // Optional: T type을 감싸는 wrapper
    Optional<ToDoAttributes> select(UUID id);

    UUID insert(final ToDoInsertAttribute attributes);

    String delete(final String targetId);

    ToDoAttributes patch(UUID id, ToDoStatus status);


}
