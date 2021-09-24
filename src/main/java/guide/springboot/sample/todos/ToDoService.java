package guide.springboot.sample.todos;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

public interface ToDoService {
    ToDoIdentifier insert(final ToDoInsertAttribute attributes);

    // void delete(final ToDoIdentifier identifier);

    // Optional<ToDo> select(final ToDoIdentifier identifier);
    Optional<ToDoAttributes> select(String id);

    List<ToDo> selectAll();

    class NoEntityException extends RuntimeException {

        public NoEntityException() {
            super();
        }

        public NoEntityException(final Throwable e) {
            super(e);
        }

        public NoEntityException(final String message) {
            super(message);
        }
    }
}
