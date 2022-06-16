package com.sofka.todolist.repository;

import com.sofka.todolist.model.ListaTarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaTareaRepository extends JpaRepository<ListaTarea, Integer> {
}