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

    public ListaTarea getListaDeTareasById(Integer id){
        return listaTareaRepository.findById(id).get();
    }
    public ListaTarea addListaDeTareas(ListaTarea listaTarea){
        listaTarea.setTareaList(null);
        return listaTareaRepository.save(listaTarea);
    }

    public void deleteListaDeTareasById(Integer id){
        listaTareaRepository.deleteById(id);
    }

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

    public Boolean existListaDeTareas(Integer id){
        return listaTareaRepository.existsById(id);
    }
}
