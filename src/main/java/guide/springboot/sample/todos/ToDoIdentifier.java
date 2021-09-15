package guide.springboot.sample.todos;

import java.util.Objects;

public class ToDoIdentifier {
    private final String value;

    public ToDoIdentifier(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null | getClass() != o.getClass()) return false;
        final ToDoIdentifier that = (ToDoIdentifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }
}
