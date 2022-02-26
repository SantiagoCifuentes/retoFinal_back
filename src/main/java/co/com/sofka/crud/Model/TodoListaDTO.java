package co.com.sofka.crud.Model;


import co.com.sofka.crud.Entities.TodoEntity;

import java.util.List;

public class TodoListaDTO
{

    private String name;
    private Long id;
    private List<TodoEntity> todoEntityList;

    public TodoListaDTO(String name, Long id, List<TodoEntity> todoEntityList) {
        this.name = name;
        this.id = id;
        this.todoEntityList = todoEntityList;
    }

    public TodoListaDTO() {

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
