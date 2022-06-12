package com.nal.javatest.todolist.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nal.javatest.todolist.model.Work;

@Repository
public interface WorkRepository extends CrudRepository<Work, Long> {

	public Page<Work> findAllByOrderByIdAsc(Pageable pageable);

	public Page<Work> findAllByOrderByIdDesc(Pageable pageable);

}
