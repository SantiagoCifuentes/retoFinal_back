package co.com.sofka.crud.Mapper;

import co.com.sofka.crud.Entities.TodoEntityList;
import co.com.sofka.crud.Entities.TodoEntity;
import co.com.sofka.crud.Model.TodoModel;
import co.com.sofka.crud.Model.TodoListaModel;

public class Mapper
{
    //Según entendí, estos métodos se realizan para poder manipular los objetos de manera más organizada

    //convirtiendo  lista de entidad a modelo
    public static TodoListaModel mapEntityListToListModel(TodoEntityList todoEntityList){
        TodoListaModel toDoListaModel = new TodoListaModel();
        toDoListaModel.setTodoEntityList(todoEntityList.getToDoListaModel());
        toDoListaModel.setId(todoEntityList.getId());
        toDoListaModel.setName(todoEntityList.getName());
        return  toDoListaModel;

    }

    //convirtiendo  lista de modelo a entidad
    public static TodoEntityList mapListToListEntity(TodoListaModel todoListaModel ){
        TodoEntityList toDoListaEntity = new TodoEntityList();
        toDoListaEntity.setToDoListaModel(todoListaModel.getTodoEntityList());
        toDoListaEntity.setName(todoListaModel.getName());
        toDoListaEntity.setId(todoListaModel.getId());
        return toDoListaEntity;
    }

    public static TodoModel mapTodoEntitytoTodoModel (TodoEntity todoEntity)
    {
        TodoModel todoModel = new TodoModel();
        todoModel.setName(todoEntity.getName());
        todoModel.setId(todoEntity.getId());
        todoModel.setCompleted(todoEntity.isCompleted());
        return todoModel;

    }

    public  static  TodoEntity mapTodoModeltoTodoEntity (TodoModel todoModel)
    {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setName(todoModel.getName());
        todoEntity.setCompleted(todoModel.isCompleted());
        todoEntity.setId(todoModel.getId());

        return todoEntity;

    }




}

