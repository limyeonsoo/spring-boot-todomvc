package guide.springboot.sample.todos.springdata;

import guide.springboot.sample.lang.UuidGenerator;
import guide.springboot.sample.todos.*;

import java.util.*;
import java.util.stream.Collectors;

public class ToDoSpringDataService implements ToDoService {
    private final ToDoSpringDataRepository toDoSpringDataRepository;
    //private final UuidGenerator uuidGenerator;


    ToDoSpringDataService(
            final ToDoSpringDataRepository toDoSpringDataRepository
           // final UuidGenerator uuidGenerator
    ){
        this.toDoSpringDataRepository = toDoSpringDataRepository;
       // this.uuidGenerator = uuidGenerator;
    }

//    static ToDo toService(final ToDoEntity entity){
//        final var identifier = new ToDoIdentifier((entity.getId()));
//
//        return new ToDo(identifier, entity.getDetails(), entity.getStatus());
//    }

    @Override
    public UUID insert(final ToDoInsertAttribute attributes){
        //final var id = uuidGenerator.generateUuidString();

        final var entity = new ToDoEntity(attributes.getDetails(), ToDoStatus.ACTIVE);

        final var saved = toDoSpringDataRepository.save(entity);

        return saved.getId();
    }

//    @Override
//    public Optional<ToDoAttributes> select(final ToDoIdentifier identifier){
//        final var id = identifier.getValue();
//
//        return toDoSpringDataRepository.findById(id);
//                //.map(ToDoSpringDataService::toService);
//    }
    @Override
    public Optional<ToDoAttributes> select(final UUID id){
        final var todoEntity = toDoSpringDataRepository.findById(id);

        return todoEntity.map(ToDoSpringDataService::toToDoAttribute);
    }

    @Override
    public List<ToDo> selectAll(){
//        final var todos = toDoSpringDataRepository.findAll();
//        System.out.println(todos);
//        return todos.stream()
//                .map(ToDoSpringDataService::toToDo)
//                .collect(Collectors.toUnmodifiableList());
        final var toDoEntities = toDoSpringDataRepository.findAll();

//        return todos.stream()
//                .map(ToDoSpringDataService::toToDo)
//                .collect(Collectors.toUnmodifiableList());
        final var toDos = new ArrayList<ToDo>();
        for(var toDoEntity : toDoEntities){
            System.out.println(toDoEntity);
            toDos.add(toToDo(toDoEntity));
        }
        System.out.println(Collections.unmodifiableList(toDos));
        return Collections.unmodifiableList(toDos);
    }

    static ToDo toToDo(final ToDoEntity todoEntity){
        final var toDoID = todoEntity.getId();

        return new ToDo(toDoID, todoEntity.getDetails(), todoEntity.getStatus());
    }


    static ToDoAttributes toToDoAttribute(final ToDoEntity toDoEntity){
        return new ToDoAttributes(toDoEntity.getDetails(), toDoEntity.getStatus());
    }
}
