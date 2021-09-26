package guide.springboot.sample.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class ToDoPatchReqJson {
    private final String details;
    private final String status;

    @JsonCreator
    ToDoPatchReqJson(
            @JsonProperty("details") final String details,
            @JsonProperty("status") final String status
    ){
        this.details = details;
        this.status = status;
    }
    String getDetails() { return details; }
    String getStatus(){
        return status;
    }
}
