package com.sofka.todolist.controller;

import com.sofka.todolist.model.ListaTarea;
import com.sofka.todolist.service.ListaTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/listatareas")
public class ListaTareaController {

    @Autowired
    private ListaTareaService listaTareaService;


    @GetMapping
    public List<ListaTarea> getAllListaDeTareas(){
        return listaTareaService.getListasDeTareas();
    }

    @GetMapping(path = "/{id}")
    public ListaTarea getListaDeTareasById(@PathVariable("id") Integer id){
        return listaTareaService.getListaDeTareasById(id);
    }

    @PostMapping()
    public void addListaDeTareas(@RequestBody ListaTarea listaTarea){
        listaTareaService.addListaDeTareas(listaTarea);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteListaDeTareas(@PathVariable("id") Integer id){
        listaTareaService.deleteListaDeTareasById(id);
    }

    @PutMapping(path = "/{id}")
    public void editListaDeTareas(@PathVariable Integer id, @RequestBody ListaTarea listaTarea){

        try {
            ListaTarea listaTareaExistente = listaTareaService.getListaDeTareasById(id);

            listaTareaExistente.setNameLista(listaTarea.getNameLista());

            listaTareaService.addListaDeTareas(listaTareaExistente);
        }catch (Exception exception){        }
        //listaTareaService.editListaDeTareas(id, listaTarea);
    }

}
