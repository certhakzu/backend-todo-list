package com.sofka.todolist.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea", nullable = false)
    private Integer id;

    @Column(name = "description_tarea", nullable = false, length = 60)
    private String descriptionTarea;

    @Lob
    @Column(name = "is_complete", nullable = false)
    private String isComplete;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lista_tareas_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// ayuda a manejar la posibles LAZY Exception que se pueden generar
    private ListaTarea listaTareas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescriptionTarea() {
        return descriptionTarea;
    }

    public void setDescriptionTarea(String descriptionTarea) {
        this.descriptionTarea = descriptionTarea;
    }

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

    public ListaTarea getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ListaTarea listaTareas) {
        this.listaTareas = listaTareas;
    }

    public Tarea(String descriptionTarea, String isComplete, ListaTarea listaTareas) {
        this.descriptionTarea = descriptionTarea;
        this.isComplete = isComplete;
        this.listaTareas = listaTareas;
    }

    public Tarea() {
    }
}