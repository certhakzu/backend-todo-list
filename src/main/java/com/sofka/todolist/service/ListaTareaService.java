package com.sofka.todolist.service;

import com.sofka.todolist.model.ListaTarea;
import com.sofka.todolist.repository.ListaTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaTareaService {

    @Autowired
    private ListaTareaRepository listaTareaRepository;

    public List<ListaTarea> getListasDeTareas(){
        return listaTareaRepository.findAll();
    }

    public void addListaDeTareas(ListaTarea listaTarea){
        listaTareaRepository.save(listaTarea);
    }

    public void deleteListaDeTareas(Integer id){
        listaTareaRepository.deleteById(id);
    }

    public void editListaDeTareas(ListaTarea listaTarea){
        if (existListaDeTareas(listaTarea)){
            for (int i = listaTareaRepository.findAll().size() - 1; i > -1; i--){
                if (listaTarea.equals(listaTareaRepository.findAll().get(i))){
                    listaTareaRepository.deleteById(listaTarea.getId());
                    listaTareaRepository.save(listaTarea);
                }
            }
        }
    }

    public Boolean existListaDeTareas(ListaTarea listaTarea){
        return listaTareaRepository.existsById(listaTarea.getId());
    }
}
