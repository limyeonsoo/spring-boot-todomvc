package guide.springboot.sample.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static java.util.Objects.requireNonNull;

class ToDoUpdateReqJson {
    private final String details;
    private final String status;

    @JsonCreator
    ToDoUpdateReqJson(
            @JsonProperty(value = "details", required = true) final String details,
            @JsonProperty(value = "status", required = true) final String status
    ) {
        this.details = requireNonNull(details);
        this.status = requireNonNull(status);
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }
}