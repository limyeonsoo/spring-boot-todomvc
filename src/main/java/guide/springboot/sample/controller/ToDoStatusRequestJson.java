package guide.springboot.sample.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ToDoStatusRequestJson {
    @NotNull
    private final String status;
    @JsonCreator
    ToDoStatusRequestJson(
            @JsonProperty("status") final String status
    ){
        this.status = status;
    }
    String getStatus(){
        return status;
    }
}
