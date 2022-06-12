package com.nal.javatest.todolist.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nal.javatest.todolist.model.Pagination;
import com.nal.javatest.todolist.model.Work;

public interface WorkService {

	public Work addWork(Work work);

	public void deleteWork(Work work);

	public Work editWork(Work work);

	public Page<Work> fetchWork(Pagination pagination, boolean isSortAsc);
	
	public Optional<Work> findById(Long id);

}
