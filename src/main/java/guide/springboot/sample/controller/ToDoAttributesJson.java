package guide.springboot.sample.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoAttributesJson {
    private final String details;

    @JsonCreator
    ToDoAttributesJson(@JsonProperty("details") final String details){
        this.details = details;
    }

    String getDetails(){
        return details;
    }
}
