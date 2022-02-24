package co.com.sofka.crud.Entities;

import javax.persistence.*;

@Entity

public class TodoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    @Column( nullable = false)
    private boolean completed;



    public TodoEntity(Long id, String name, Boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;

    }

    public  TodoEntity()
    {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
