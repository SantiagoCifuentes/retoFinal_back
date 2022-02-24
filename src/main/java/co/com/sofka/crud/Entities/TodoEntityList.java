package co.com.sofka.crud.Entities;

import javax.persistence.*;
import java.util.List;

@Entity

public class TodoEntityList
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TodoEntity> toDoListaModel;

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

    public List<TodoEntity> getToDoListaModel() {
        return toDoListaModel;
    }

    public void setToDoListaModel(List<TodoEntity> toDoListaModel) {
        this.toDoListaModel = toDoListaModel;
    }

    public TodoEntityList(Long id, String name, List<TodoEntity> toDoListaModel) {
        this.id = id;
        this.name = name;
        this.toDoListaModel = toDoListaModel;
    }

    public TodoEntityList()
    {

    }
}
