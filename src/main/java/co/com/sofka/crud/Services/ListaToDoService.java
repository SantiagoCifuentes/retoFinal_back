package co.com.sofka.crud.Services;


import co.com.sofka.crud.Repository.ListatoDoRepository;
import co.com.sofka.crud.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaToDoService
{
    @Autowired
    ListatoDoRepository listatoDoRepository;

    @Autowired
    TodoRepository todoRepository;




}
