package guide.springboot.sample.controller;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//public class ToDoAttributesJson {
//    // GET {id}를 하면 id를 빼고 보여줌/  details & status
//    private final String details;
//    private final String status;
//
//    @JsonCreator
//    public ToDoAttributesJson(
//            @JsonProperty("details") final String details,
//            @JsonProperty("status") final String status
//    ){
//        System.out.println("run constructor...");
//        this.details = details;
//        this.status = status;
//    }
//
//    String getDetails(){
//        return details;
//    }
//    String getStatus() { return status; }
//}


import static java.util.Objects.requireNonNull;

public class ToDoAttributesJson {
    private final String details;
    private final String status;

    ToDoAttributesJson(final String details, final String status) {
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