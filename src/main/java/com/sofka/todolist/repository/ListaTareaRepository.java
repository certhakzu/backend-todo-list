package com.sofka.todolist.repository;

import com.sofka.todolist.model.ListaTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaTareaRepository extends JpaRepository<ListaTarea, Integer> {
}