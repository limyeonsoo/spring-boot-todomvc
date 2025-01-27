package guide.springboot.sample.todos.springdata;

import guide.springboot.sample.lang.UuidGenerator;
import guide.springboot.sample.todos.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNullElse;

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

        return todoEntity.map(ToDoSpringDataService::toToDoAttributes);
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
            toDos.add(toToDo(toDoEntity));
        }
        return Collections.unmodifiableList(toDos);
    }

    @Override
    public String delete(final String targetId){
        final var targetUUID = UUID.fromString(targetId);
        if(toDoSpringDataRepository.existsById(targetUUID)){
            final var toDoEntity = toDoSpringDataRepository.findById(targetUUID);
            toDoSpringDataRepository.deleteById(targetUUID);
            System.out.println(toDoEntity.get().getDetails());
            System.out.println(toDoEntity.get().getStatus().name());
            return "Delete Success";
        }
        return "No Such Element";
    }

    @Override
    public ToDoAttributes patch(final UUID id, String details, ToDoStatus status){
        final var current = toDoSpringDataRepository.findById(id);

        final var willUpdate = new ToDoEntity(
                id,
                requireNonNullElse(details, current.get().getDetails()),
                requireNonNullElse(status, current.get().getStatus())
        );

        // 그냥 save를 하면 overwrite될까? => Persisting Entities
        toDoSpringDataRepository.save(willUpdate);
        return new ToDoAttributes(willUpdate.getDetails(), willUpdate.getStatus());
    }

    @Override
    public ToDo update(UUID id, String details, ToDoStatus status) {

        final var updated = new ToDoEntity(id, details, status);

        toDoSpringDataRepository.save(updated);

        return new ToDo(updated.getId(), updated.getDetails(), updated.getStatus());
    }

    static ToDo toToDo(final ToDoEntity todoEntity){
        final var toDoID = todoEntity.getId();

        return new ToDo(toDoID, todoEntity.getDetails(), todoEntity.getStatus());
    }


    static ToDoAttributes toToDoAttributes(final ToDoEntity toDoEntity){
        return new ToDoAttributes(toDoEntity.getDetails(), toDoEntity.getStatus());
    }
}
