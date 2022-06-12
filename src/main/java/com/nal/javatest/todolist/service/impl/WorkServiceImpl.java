package com.nal.javatest.todolist.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nal.javatest.todolist.model.Pagination;
import com.nal.javatest.todolist.model.Work;
import com.nal.javatest.todolist.repository.WorkRepository;
import com.nal.javatest.todolist.service.WorkService;

/**
 * @author lnsang
 *
 */
@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkRepository workRepository;

	/**
	 * Add a work
	 * @param work This is the first parameter to add a work
	 * @return {@link Work} This returns a work
	 */
	@Override
	@Transactional
	public Work addWork(Work work) {
		return workRepository.save(work);
	}

	/**
	 * Delete a work
	 * @param work This is the first parameter to delete a work
	 */
	@Override
	@Transactional
	public void deleteWork(Work work) {
		workRepository.delete(work);
	}

	/**
	 * Update a work
	 * @param work This is the first parameter to update a work
	 * @return {@link Work} This returns a work
	 */
	@Override
	@Transactional
	public Work editWork(Work work) {
		return workRepository.save(work);
	}

	/**
	 * Find all works
	 * @param pagination This is the first parameter to paging method
	 * @param isSortAsc This is the second parameter to sorting method
	 * @return Page<Work> This returns list of work
	 */
	@Override
	public Page<Work> fetchWork(Pagination pagination, boolean isSortAsc) {
		if (isSortAsc) {
			return workRepository
					.findAllByOrderByIdAsc(PageRequest.of(pagination.getCurrentPage() - 1, pagination.getPageSize()));
		} else {
			return workRepository
					.findAllByOrderByIdDesc(PageRequest.of(pagination.getCurrentPage() - 1, pagination.getPageSize()));
		}
	}

	/**
	 * Find a work by id
	 * @param id This is parmeter of a work
	 * @return {@link Work} This return a work
	 */
	@Override
	public Optional<Work> findById(Long id) {
		return workRepository.findById(id);
	}

}
