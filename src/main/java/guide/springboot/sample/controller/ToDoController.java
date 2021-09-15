package guide.springboot.sample.controller;

import guide.springboot.sample.todos.ToDo;
import guide.springboot.sample.todos.ToDoAttributes;
import guide.springboot.sample.todos.ToDoService;
import guide.springboot.sample.todos.ToDoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
@Validated
@SpringBootApplication(scanBasePackages={"guide.springboot.sample.todos"})
class ToDoController {
    private final ToDoService toDoService;

    ToDoController(final ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getRequest(){
        final var todos = toDoService.selectAll();


//        String str = "";
//
//        for(ToDo td : todos){
//            str += toJson(td);
//        }
        //return todos.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
        return todos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ToDoIdentifierJson create(@Valid @RequestBody final ToDoAttributesJson booAttributesJson){
        final var request = new ToDoAttributes((booAttributesJson.getDetails()));

        final var identifier = toDoService.insert(request);

        return new ToDoIdentifierJson(new ToDo(identifier, request.getDetails(), "active"));

    }

    static Map<String, String> toModel(final ToDo todo){
        return Map.of(
                "id", todo.getId(),
                "detail", todo.getDetails(),
                "status", todo.getStatus()
        );
    }

    static ToDoJson toJson(final ToDo todo){
        final var id = todo.getId();
        return new ToDoJson(id, todo.getDetails(), todo.getStatus());
    }

}
