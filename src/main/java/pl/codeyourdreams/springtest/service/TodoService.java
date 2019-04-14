package pl.codeyourdreams.springtest.service;

import pl.codeyourdreams.springtest.model.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> findAll();
}
