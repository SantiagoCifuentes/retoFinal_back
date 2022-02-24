package co.com.sofka.crud.Services;

import co.com.sofka.crud.Entities.TodoEntity;
import co.com.sofka.crud.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static javax.swing.UIManager.get;

@Service
public class TodoService {

    @Autowired
    private TodoRepository toDorepository;



    public Iterable<TodoEntity> list(){
        return toDorepository.findAll();
    }

    public TodoEntity save(TodoEntity todo){
        return toDorepository.save(todo);
    }

    public void delete(Long id){
        toDorepository.delete(get(id));
    }

    public TodoEntity get(Long id){
         return toDorepository.findById(id).orElseThrow();
    }

}
