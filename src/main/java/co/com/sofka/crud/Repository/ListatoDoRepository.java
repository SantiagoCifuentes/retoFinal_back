package co.com.sofka.crud.Repository;

import co.com.sofka.crud.Entities.TodoEntityList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ListatoDoRepository extends CrudRepository<TodoEntityList, Long>
{


}
