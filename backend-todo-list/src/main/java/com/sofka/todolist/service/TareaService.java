package com.sofka.todolist.service;

import com.sofka.todolist.model.ListaTarea;
import com.sofka.todolist.model.Tarea;
import com.sofka.todolist.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getAllTareas(){
        return tareaRepository.findAll();
    }

    public List<Tarea> getAllTareasByIdListaDeTareas(Integer idListaDeTareas){
        List<Tarea> listaTarea = new ArrayList<>();
        for (Tarea tarea : tareaRepository.findAll()){
            if (tarea.getListaTareas().getId().equals(idListaDeTareas)){
                listaTarea.add(tarea);
            }
        }
        return listaTarea;
    }

    public void deleteTarea(Integer id){
        if (existTarea(id)){
            tareaRepository.delete(tareaRepository.getReferenceById(id));
        }
    }

    public Boolean existTarea(Integer id){
        return tareaRepository.existsById(id);
    }

    public void editTarea(Tarea tarea){

    }

    public void setIsCompletTarea(Integer id, Boolean flag){
        tareaRepository.findById(id).get().setIsComplete(flag.toString().toLowerCase());
    }
}
