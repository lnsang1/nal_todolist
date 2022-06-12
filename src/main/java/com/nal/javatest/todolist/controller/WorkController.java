package com.nal.javatest.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nal.javatest.todolist.constant.UrlConstants;
import com.nal.javatest.todolist.dto.ResponseAPI;
import com.nal.javatest.todolist.model.Pagination;
import com.nal.javatest.todolist.model.Work;
import com.nal.javatest.todolist.service.WorkService;

@RestController
@RequestMapping(UrlConstants.URL_API_V1)
public class WorkController extends BaseController {

	@Autowired
	private WorkService workService;

	@PostMapping(UrlConstants.URL_API_WORK)
	public ResponseAPI<Work> addWork(@RequestBody Work work) throws Exception {
		try {
			return success(workService.addWork(work));
		} catch (Exception e) {
			return error(e.getMessage());
		}
	}

	@PutMapping(UrlConstants.URL_API_WORK + "/{id}")
	public ResponseAPI<Work> updateWork(@RequestBody Work work, @PathVariable("id") Long id) throws Exception {
		try {
			return success(workService.findById(id).map(item -> {
				item.setName(work.getName());
				item.setStatus(work.getStatus());
				item.setStartDate(work.getStartDate());
				item.setEndDate(work.getEndDate());
				return workService.editWork(item);
			}).orElseGet(() -> workService.addWork(work)));
		} catch (Exception e) {
			return error(e.getMessage());
		}
	}

	@DeleteMapping(UrlConstants.URL_API_WORK + "/{id}")
	public ResponseAPI<Boolean> removeWork(@PathVariable("id") Long id) throws Exception {
		try {
			workService.findById(id).ifPresent(item -> {
				workService.deleteWork(item);
			});
			return success(true);
		} catch (Exception e) {
			return error(e.getMessage());
		}
	}

	@GetMapping(UrlConstants.URL_API_WORK)
	public ResponseAPI<Page<Work>> fetchWork(
			@RequestParam(defaultValue = "1", value = "page", required = false) int page,
			@RequestParam(defaultValue = "10", value = "size", required = false) int size,
			@RequestParam(defaultValue = "false", value = "isSortAsc", required = false) Boolean isSortAsc)
			throws Exception {
		try {
			Pagination pagination = new Pagination(page, size);
			return success(workService.fetchWork(pagination, isSortAsc));
		} catch (Exception e) {
			return error(e.getMessage());
		}
	}

}
