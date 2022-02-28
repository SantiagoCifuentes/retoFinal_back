package co.com.sofka.crud.Controller;

import co.com.sofka.crud.Entities.TodoEntity;
import co.com.sofka.crud.Entities.TodoEntityList;
import co.com.sofka.crud.Model.TodoListaDTO;
import co.com.sofka.crud.Model.TodoDTO;
import co.com.sofka.crud.Services.ListaToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private ListaToDoService listaToDoService;

    //obtiene los todos por id de lista
    @GetMapping(value = "/todos/{listId}")
    public List<TodoDTO> findByTodosId(@PathVariable("listId")Long listId)
    {
        return listaToDoService.getTodosById(listId);
    }


    //guarda un todo por lista
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/todolist")
    public TodoListaDTO save(@RequestBody TodoListaDTO todoListaDTO){
        return listaToDoService.createToDoList(todoListaDTO);
    }

    //obtener los todos de la lista

    @CrossOrigin(origins = "http://localhost:3000") //si no ponía este cross origins aquí , me tiraba error
    @GetMapping(value = "/todos")
    public Iterable<TodoEntityList> findTodos() {
        return listaToDoService.obtenerTodos();
    }


    @PutMapping("/actualizarLista")
    public TodoListaDTO editarNombreLista(@RequestBody TodoListaDTO todoListaDTO){
        return (TodoListaDTO) listaToDoService.editTodoList(todoListaDTO);

    }


    //guarda una nuevo to do por id de la lista
    @PostMapping("/todo/{listId}")
    public TodoDTO saveNewTodoByListId(@PathVariable("listId") Long listId, @RequestBody TodoDTO todoDTO){
        return listaToDoService.guardarTodoaLista(listId, todoDTO);
    }
    //actualiza un to do
    @PutMapping(value = "/todo/{listId}")
    public TodoDTO updateTodo(@PathVariable("listId") Long listId, @RequestBody TodoDTO todoDTO){
        return listaToDoService.updateToDoByListId(listId, todoDTO);
    }

    //elimina una lista por id
    @DeleteMapping("/todolist/{listId}")
    public void removeTodoListById(@PathVariable("listId") Long listId){
        listaToDoService.removeTodoListById(listId);
    }

    //elimina un to do por id
    @DeleteMapping("/todo/{todoId}")
    public void removeTodoById(@PathVariable("todoId") Long todoId){
        listaToDoService.removeTodoById(todoId);
    }

    //encuentra un todo por id
    @GetMapping(value = "api/{id}/todo")
    public TodoEntity get(@PathVariable("id") Long id){
        return listaToDoService.get(id);
    }

}
