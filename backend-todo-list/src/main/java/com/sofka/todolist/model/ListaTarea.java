package com.sofka.todolist.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lista_tareas")
public class ListaTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_tareas", nullable = false)
    private Integer id;

    @Column(name = "name_lista", nullable = false, length = 30)
    private String nameLista;

    @OneToMany(mappedBy = "listaTareas", cascade = CascadeType.ALL)
    private List<Tarea> tareaList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameLista() {
        return nameLista;
    }

    public void setNameLista(String nameLista) {
        this.nameLista = nameLista;
    }

    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    public ListaTarea(String nameLista, List<Tarea> tareaList) {
        this.nameLista = nameLista;
        this.tareaList = tareaList;
    }

    public ListaTarea() {
    }
}