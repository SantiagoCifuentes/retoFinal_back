package co.com.sofka.crud.Services;


import co.com.sofka.crud.Entities.TodoEntity;
import co.com.sofka.crud.Entities.TodoEntityList;
import co.com.sofka.crud.Mapper.Mapper;
import co.com.sofka.crud.Model.TodoListaDTO;
import co.com.sofka.crud.Model.TodoDTO;
import co.com.sofka.crud.Repository.ListatoDoRepository;
import co.com.sofka.crud.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaToDoService
{
    @Autowired
    ListatoDoRepository listatoDoRepository;

    @Autowired
    TodoRepository todoRepository;



    //obteniendo todos de una lista

    public  List<TodoDTO>getTodosFromList(Optional <TodoEntityList> todoEntityList)
    {
        return  todoEntityList.orElseGet(TodoEntityList::new) //se utiliza el orElseGet ya que si no existen las listas, se creará un objeto de este tipo
                .getToDoListaModel().stream().map(todoEntity -> new TodoDTO(todoEntity.getId(),todoEntity.getName(),todoEntity.isCompleted()
                        ,todoEntityList.get().getId())).collect(Collectors.toList());
    }





    //obteniendo todos de una lista por id
    public List<TodoDTO> getTodosById(Long listId)
    {
        var toDoLista = listatoDoRepository.findById(listId);
        return getTodosFromList(toDoLista);
    }

    //creando nueva lista de to dos

    public TodoListaDTO createToDoList(TodoListaDTO todoListaDTO){
        TodoEntityList todoList = new TodoEntityList();
        todoList.setId(todoListaDTO.getId());
        todoList.setName(todoListaDTO.getName());
        todoList.setToDoListaModel(new ArrayList<>());
        return Mapper.mapEntityListToListModel(listatoDoRepository.save(todoList));
    }


    //guardar un to do a una lista por id

    public TodoDTO guardarTodoaLista(Long listId, TodoDTO todoDTO){
        var _toDoList = listatoDoRepository.findById(listId);
        if (todoDTO.getName().isEmpty()){
            throw new RuntimeException("Se necesita ponerle un nombre");
        }

        var _toDo = Mapper.mapTodoModeltoTodoEntity(todoDTO);

        _toDoList.orElseGet(TodoEntityList::new).getToDoListaModel().add(_toDo);
        var listUpdated = listatoDoRepository.save(_toDoList.get());
        var insertedToDo = listUpdated.getToDoListaModel()
                .stream()
                .max(Comparator.comparing(item -> item.getId().intValue()))
                .orElseThrow();
        todoDTO.setId(insertedToDo.getId());
        todoDTO.setGroupListId(listId);
        return todoDTO;
    }

    public Object editTodoList(TodoListaDTO todoListaDTO) {
        TodoListaDTO listaNueva = new TodoListaDTO();
        var lista = listatoDoRepository.findById(todoListaDTO.getId());
        if (lista.isPresent()) {
            listatoDoRepository.save(Mapper.mapListToListEntity(todoListaDTO));
            return todoListaDTO;
        }
        return null;
    }


    //Editar todos en listas

    private List<TodoEntity> editTodosInList(TodoEntityList todoList, TodoDTO todoDTO){
        return todoList.getToDoListaModel()
                .stream()
                .map(todoEntity -> {
                    if (todoEntity.getId().equals(todoDTO.getId())){
                        todoEntity.setName(todoDTO.getName());
                        todoEntity.setCompleted(todoDTO.isCompleted());
                    }
                    return todoEntity;
                })
                .collect(Collectors.toList());
    }


    //actualizar To Do por lista de id
    public TodoDTO updateToDoByListId(Long listId, TodoDTO todoDTO){
        var TodoList =listatoDoRepository.findById(listId);

        if (todoDTO.getName().isEmpty()) {
            throw new RuntimeException("Se necesita ponerle un nombre");
        }
        var updatedTodos = editTodosInList(TodoList.orElseGet(TodoEntityList::new), todoDTO);
        TodoEntityList todoLista = new TodoEntityList();
        todoLista.setId(TodoList.orElseGet(TodoEntityList::new).getId());
        todoLista.setName(TodoList.orElseGet(TodoEntityList::new).getName());
        todoLista.setToDoListaModel(TodoList.orElseGet(TodoEntityList::new).getToDoListaModel());
        listatoDoRepository.save(todoLista);
        todoDTO.setGroupListId(listId);
        return todoDTO;
    }



    public Iterable<TodoEntityList> obtenerTodos() {
        return listatoDoRepository.findAll();
    }







    public void removeTodoListById(Long id){
        var toDoList = listatoDoRepository.findById(id).orElseThrow();
        listatoDoRepository.delete(toDoList);
    }
    public void removeTodoById(Long id){
        var toDo = todoRepository.findById(id).orElseThrow();
        todoRepository.delete(toDo);
    }

 //se repiten los métodos ya que se llamó la entidad Todo


    public Iterable<TodoEntity> list(){
        return todoRepository.findAll();
    }

    public TodoEntity save(TodoEntity todo){
        return todoRepository.save(todo);
    }

    public void delete(Long id){
        todoRepository.delete(get(id));
    }

    public TodoEntity get(Long id){
        return todoRepository.findById(id).orElseThrow();
    }


}
