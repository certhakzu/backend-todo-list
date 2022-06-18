package com.sofka.todolist.controller;

import com.sofka.todolist.model.ListaTarea;
import com.sofka.todolist.model.Tarea;
import com.sofka.todolist.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping()
    public List<Tarea> getAllTareas(){
        return tareaService.getAllTareas();
    }

    @GetMapping(path = "/{id}")
    public Tarea getTareaById(@PathVariable("id") Integer id){
        return tareaService.getTareaById(id);
    }

    @PostMapping()
    public Tarea addTarea(@RequestBody Tarea tarea){
        return tareaService.addTarea(tarea);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTarea(@PathVariable("id") Integer id){
        return tareaService.deleteTareaById(id);
    }

    @PutMapping(path = "/{id}")
    public void editTarea(@PathVariable Integer id, @RequestBody Tarea tarea){

        try {
            Tarea tareaExistente = tareaService.getTareaById(id);

            tareaExistente.setDescriptionTarea(tarea.getDescriptionTarea());
            tareaExistente.setIsComplete(tarea.getIsComplete());
            tareaExistente.setListaTareas(tarea.getListaTareas());

            tareaService.addTarea(tareaExistente);
        }catch (Exception exception){        }
        //tareaService.editTarea(id, tarea);
    }

}
