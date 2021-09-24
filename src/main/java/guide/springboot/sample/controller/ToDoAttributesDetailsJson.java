package guide.springboot.sample.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoAttributesDetailsJson {
    private final String details;
    @JsonCreator
    ToDoAttributesDetailsJson(
            @JsonProperty("details") final String details
    ){
        this.details = details;
    }
    String getDetails(){
        return details;
    }
}
