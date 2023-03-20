package classes;

import java.util.List;

public class Lessons {
    private long id;
    private String name;
    private String description;

    public Lessons(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Lessons() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lessons: \n" +
                "id: " + id +"\n"+
                "name: " + name + "\n"+
                "description: " + description ;
    }
}
