package guide.springboot.sample.controller;

class ToDoJson{
    private final String details;
    private final String id;
    private final String status;

    ToDoJson(final String id, final String details, String status){
        this.details = details;
        this.id = id;
        this.status = status;
    }

    public String getTitle(){
        return details;
    }

    public String getId(){
        return id;
    }
    public String getStatus(){
        return status;
    }
}
