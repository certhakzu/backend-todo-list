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

    public  Tarea getTareaById(Integer id){
        return tareaRepository.findById(id).get();
    }

    public Tarea addTarea(Tarea tarea){
        return tareaRepository.save(tarea);
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

    public String deleteTareaById(Integer id){
        if (existTarea(id)){
            tareaRepository.deleteById(id);
            return "Delete Tarea ok";
        }
        return "Delete Tarea Falló";
    }

    public Boolean existTarea(Integer id){
        return tareaRepository.existsById(id);
    }

    public void editTarea(Integer id, Tarea tarea){
        /*
        public void editListaDeTareas(Integer id, ListaTarea nuevaListaTarea){
        if (existListaDeTareas(id)){
            for (int i = listaTareaRepository.findAll().size() - 1; i > -1; i--){
                if (nuevaListaTarea.equals(listaTareaRepository.findAll().get(i))){
                    listaTareaRepository.deleteById(id);
                    listaTareaRepository.save(nuevaListaTarea);
                }
            }
        }
    }
         */
        if (existTarea(id)){
            tareaRepository.deleteById(id);
            tareaRepository.save(tarea);
        }
    }

    public void setIsCompletTarea(Integer id, Boolean flag){
        tareaRepository.findById(id).get().setIsComplete(flag);
    }
}
