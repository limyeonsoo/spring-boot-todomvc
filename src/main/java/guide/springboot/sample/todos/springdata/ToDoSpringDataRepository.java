package guide.springboot.sample.todos.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

interface ToDoSpringDataRepository extends JpaRepository<ToDoEntity, String> {
}
