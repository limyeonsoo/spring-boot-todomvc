package guide.springboot.sample.controller;

import static java.util.Objects.requireNonNull;

class ToDoStringJson{
    private final String response;

    ToDoStringJson(final String res){
        this.response = requireNonNull(res);
    }

    public String getResponse(){
        return response;
    }
}
