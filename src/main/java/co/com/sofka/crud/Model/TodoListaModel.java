package co.com.sofka.crud.Model;


import co.com.sofka.crud.Entities.TodoEntity;

import java.util.List;

public class TodoListaModel
{

    private String name;
    private Long id;
    private List<TodoEntity> todoEntityList;

    public TodoListaModel(String name, Long id, List<TodoEntity> todoEntityList) {
        this.name = name;
        this.id = id;
        this.todoEntityList = todoEntityList;
    }

    public TodoListaModel() {

    }

    public List<TodoEntity> getTodoEntityList() {
        return todoEntityList;
    }

    public void setTodoEntityList(List<TodoEntity> todoEntityList) {
        this.todoEntityList = todoEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





    
}
