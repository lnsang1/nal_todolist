package com.nal.javatest.todolist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.nal.javatest.todolist.constant.StatusEnum;
import com.nal.javatest.todolist.model.Pagination;
import com.nal.javatest.todolist.model.Work;
import com.nal.javatest.todolist.service.WorkService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class TodolistApplicationTests {

	@Autowired
	private WorkService workService;

	@Test
	@Order(1)
	void testAddWork() {
		Work work = new Work();
		work.setId(1L);
		work.setName("reading book");
		work.setStatus(StatusEnum.PLANNING);
		work.setStartDate(new Date());
		work.setStartDate(new Date());
		workService.addWork(work);
		assertNotNull(workService.findById(1L));
	}
	
	@Test
	@Order(2)
	void testFetchWork() {
		Pagination pagination = new Pagination(1, 10);
		Page<Work> workPage = workService.fetchWork(pagination, false);
		assertThat(workPage).size().isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	void testFindOneWork() {
		Work work = workService.findById(1L).get();
		assertEquals(StatusEnum.PLANNING, work.getStatus());
	}

	@Test
	@Order(4)
	void testUpdateWork() {
		Work work = workService.findById(1L).get();
		work.setStatus(StatusEnum.DOING);
		workService.editWork(work);
		assertNotEquals(StatusEnum.PLANNING, workService.findById(1L).get());
	}
	
	@Test
	@Order(5)
	void testDeleteWork() {
		Work work = workService.findById(1L).get();
		workService.deleteWork(work);
		assertThat(workService.findById(1L)).isEmpty();
	}

}
