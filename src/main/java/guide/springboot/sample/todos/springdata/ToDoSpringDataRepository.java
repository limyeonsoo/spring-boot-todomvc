package guide.springboot.sample.todos.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

//interface ToDoSpringDataRepository extends JpaRepository<ToDoEntity, String> {
//    Optional<ToDoEntity> findById(String id);
//}

// JpaRepository extends PagingAndSortingRepository which in turn extends CrudRepository.
interface ToDoSpringDataRepository extends CrudRepository<ToDoEntity, UUID>{ }
