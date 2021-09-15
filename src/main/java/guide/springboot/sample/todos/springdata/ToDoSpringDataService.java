package guide.springboot.sample.todos.springdata;

import guide.springboot.sample.lang.UuidGenerator;
import guide.springboot.sample.todos.ToDo;
import guide.springboot.sample.todos.ToDoAttributes;
import guide.springboot.sample.todos.ToDoIdentifier;
import guide.springboot.sample.todos.ToDoService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ToDoSpringDataService implements ToDoService {
    private final ToDoSpringDataRepository toDoSpringDataRepository;
    private final UuidGenerator uuidGenerator;


    ToDoSpringDataService(
            final ToDoSpringDataRepository toDoSpringDataRepository,
            final UuidGenerator uuidGenerator
    ){
        this.toDoSpringDataRepository = toDoSpringDataRepository;
        this.uuidGenerator = uuidGenerator;
    }

    static ToDo toService(final ToDoEntity entity){
        final var identifier = new ToDoIdentifier((entity.getId()));

        return new ToDo(identifier, entity.getDetails(), entity.getStatus());
    }

    @Override
    public ToDoIdentifier insert(final ToDoAttributes attributes){
        final var id = uuidGenerator.generateUuidString();
        final var entity = new ToDoEntity(id, attributes.getDetails(), "active");

        final var saved = toDoSpringDataRepository.save(entity);

        return new ToDoIdentifier(saved.getId());
    }

    @Override
    public Optional<ToDo> select(final ToDoIdentifier identifier){
        final var id = identifier.getValue();

        return toDoSpringDataRepository.findById(id)
                .map(ToDoSpringDataService::toService);
    }

    @Override
    public List<ToDo> selectAll(){
        final var todos = toDoSpringDataRepository.findAll();

        return todos.stream()
                .map(ToDoSpringDataService::toService)
                .collect(Collectors.toUnmodifiableList());
    }


}
