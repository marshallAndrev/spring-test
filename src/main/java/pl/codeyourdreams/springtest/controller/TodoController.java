package pl.codeyourdreams.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.codeyourdreams.springtest.service.TodoService;

@Controller
public class TodoController {


    @Autowired
    TodoService todoService;

    @GetMapping("/todosView")
    String getTodosView(Model model) {
        model.addAttribute("lista", todoService.findAll());

        return "todos";



    }


}
