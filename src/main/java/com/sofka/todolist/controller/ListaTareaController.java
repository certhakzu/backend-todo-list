package com.sofka.todolist.controller;

import com.sofka.todolist.model.ListaTarea;
import com.sofka.todolist.service.ListaTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lista_tareas")
public class ListaTareaController {

    @Autowired
    private ListaTareaService listaTareaService;

    @GetMapping
    public List<ListaTarea> getAllListaDeTareas(){
        return listaTareaService.getListasDeTareas();
    }
}
