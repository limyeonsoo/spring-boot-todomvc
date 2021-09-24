package guide.springboot.sample.controller;

class ToDoJson{
    private final String id;
    private final String details;
    private final String status;

    ToDoJson(final String id, final String details, String status){
        this.id = id;
        this.details = details;
        this.status = status;
    }

    public String getId(){
        return id;
    }
    public String getDetails(){
        return details;
    }
    public String getStatus(){
        return status;
    }
}
