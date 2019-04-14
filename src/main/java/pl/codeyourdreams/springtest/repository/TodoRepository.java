package pl.codeyourdreams.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.codeyourdreams.springtest.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
