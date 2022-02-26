package co.com.sofka.crud.Mapper;

import co.com.sofka.crud.Entities.TodoEntityList;
import co.com.sofka.crud.Entities.TodoEntity;
import co.com.sofka.crud.Model.TodoDTO;
import co.com.sofka.crud.Model.TodoListaDTO;

public class Mapper
{
    //Según entendí, estos métodos se realizan para poder manipular los objetos de manera más organizada

    //convirtiendo  lista de entidad a modelo
    public static TodoListaDTO mapEntityListToListModel(TodoEntityList todoEntityList){
        TodoListaDTO toDoListaDTO = new TodoListaDTO();
        toDoListaDTO.setTodoEntityList(todoEntityList.getToDoListaModel());
        toDoListaDTO.setId(todoEntityList.getId());
        toDoListaDTO.setName(todoEntityList.getName());
        return toDoListaDTO;

    }



    //convirtiendo  lista de modelo a entidad
    public static TodoEntityList mapListToListEntity(TodoListaDTO todoListaDTO){
        TodoEntityList toDoListaEntity = new TodoEntityList();
        toDoListaEntity.setName(todoListaDTO.getName());
        toDoListaEntity.setId(todoListaDTO.getId());
        toDoListaEntity.setToDoListaModel(todoListaDTO.getTodoEntityList());
        return toDoListaEntity;
    }





    public static TodoDTO mapTodoEntitytoTodoModel (TodoEntity todoEntity)
    {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setName(todoEntity.getName());
        todoDTO.setId(todoEntity.getId());
        todoDTO.setCompleted(todoEntity.isCompleted());
        return todoDTO;

    }

    public  static  TodoEntity mapTodoModeltoTodoEntity (TodoDTO todoDTO)
    {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setName(todoDTO.getName());
        todoEntity.setCompleted(todoDTO.isCompleted());
        todoEntity.setId(todoDTO.getId());

        return todoEntity;

    }






}

