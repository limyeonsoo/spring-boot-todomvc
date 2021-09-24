package guide.springboot.sample.todos.springdata;

import guide.springboot.sample.lang.UuidGenerator;
import guide.springboot.sample.todos.ToDoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ToDoServiceConfig {
//    @Bean
//    UuidGenerator uuidGenerator(){
//        return new UuidGenerator();
//    }

    @Bean
    ToDoService toDoService(
            final ToDoSpringDataRepository toDoSpringDataRepository
            // final UuidGenerator uuidGenerator
    ){
        return new ToDoSpringDataService(toDoSpringDataRepository);
    }
}
