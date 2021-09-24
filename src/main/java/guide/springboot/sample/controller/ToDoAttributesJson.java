package guide.springboot.sample.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoAttributesJson {
    // GET {id}를 하면 id를 빼고 보여줌/  details & status
    private final String details;
    private final String status;

    @JsonCreator
    ToDoAttributesJson(
            @JsonProperty("details") final String details,
            @JsonProperty("status") final String status
    ){
        this.details = details;
        this.status = status;
    }

    String getDetails(){
        return details;
    }
    String getStatus() { return status; }
}
