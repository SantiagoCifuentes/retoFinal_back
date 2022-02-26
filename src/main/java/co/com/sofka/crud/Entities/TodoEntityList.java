package co.com.sofka.crud.Entities;

import javax.persistence.*;
import java.util.List;

@Entity

public class TodoEntityList
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_do_list_id")
    private List<TodoEntity> toDoListaModel;


    public List<TodoEntity> getToDoListaModel() {
        return toDoListaModel;
    }

    public void setToDoListaModel(List<TodoEntity> toDoListaModel) {
        this.toDoListaModel = toDoListaModel;
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



    public TodoEntityList(Long id, String name, List<TodoEntity> toDoListaModel) {
        this.id = id;
        this.name = name;
        this.toDoListaModel = toDoListaModel;
    }

    public TodoEntityList()
    {

    }
}
