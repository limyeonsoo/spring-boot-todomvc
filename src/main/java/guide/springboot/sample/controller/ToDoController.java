package guide.springboot.sample.controller;

import guide.springboot.sample.todos.*;
import guide.springboot.sample.todos.ToDoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
// @Validated
// @SpringBootApplication(scanBasePackages={"guide.springboot.sample.todos"})
class ToDoController {
    private final ToDoService toDoService;

    ToDoController(final ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    List<ToDoJson> getRequest(){
        final var todos = toDoService.selectAll();
//        System.out.println(todos);
//        return todos.stream()
//                .map(ToDoController::toJson)
//                .collect(Collectors.toUnmodifiableList());
        return todos.stream()
                .map(ToDoController::toToDoJson)
                .collect(Collectors.toUnmodifiableList());
    }

    @GetMapping("/{id}")
    ResponseEntity<ToDoAttributesJson> getAttRequest(
            @PathVariable("id")
            final String toDoIdString
    ){
        final var toDoId = UUID.fromString(toDoIdString);

        final var toDo = toDoService.select(toDoId);

        return ResponseEntity.of(toDo.map(ToDoController::toToDoAttributeResponse));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ToDoIdResponse create(@Valid @RequestBody final ToDoAttributesDetailsJson booAttributesJson){
        //final var request = new ToDoAttributes((booAttributesJson.getDetails()));
        final var request = new ToDoInsertAttribute(booAttributesJson.getDetails());
        final var identifier = toDoService.insert(request);

        return toToDoIdResponse(identifier);
    }

    static ToDoJson toToDoJson(final ToDo todo){
        return new ToDoJson(
                todo.getId().toString(),
                todo.getDetails(),
                todo.getStatus().name().toLowerCase(Locale.ENGLISH));
    }

    static ToDoAttributesJson toToDoAttributeResponse(final ToDoAttributes todo){
        return new ToDoAttributesJson(
                todo.getDetails(),
                todo.getStatus().name().toLowerCase(Locale.ENGLISH)
        );
    }

    static ToDoIdResponse toToDoIdResponse(final UUID id){
        return new ToDoIdResponse(id.toString());
    }
}
