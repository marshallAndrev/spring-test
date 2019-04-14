package pl.codeyourdreams.springtest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.codeyourdreams.springtest.model.Todo;
import pl.codeyourdreams.springtest.service.TodoService;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TodoService todoService;

    @Test
    public void findAllValidTest() throws Exception {
        Todo todo = new Todo(1L, "Zakupy", "chleb");

        Todo todo2 = new Todo(2L, "Remont", "kolanko");

        List<Todo> todos = new ArrayList<>();
        todos.add(todo);
        todos.add(todo2);

        when(todoService.findAll()).thenReturn(todos);

        mockMvc.perform(get("/todosView"))
                .andExpect(status().isOk())
                .andExpect(view().name("todos"))
                .andExpect(model().attribute("lista", hasSize(2)));

    }
}