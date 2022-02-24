package co.com.sofka.crud.Repository;

import co.com.sofka.crud.Entities.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends CrudRepository<TodoEntity, Long>
{

}
