package com.worker.employees.services;

import com.worker.employees.dto.ProjectsTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EmployeeServiceImplTest {

    @Test
    void getNumberUniqueEmployeesFromMap() {
        final var task1 = new HashMap<String, String>();
        task1.put("task_id", "1");
        task1.put("assignee_id", "001");
        task1.put("task_state", "active");

        final var task2 = new HashMap<String, String>();
        task2.put("task_id", "1");
        task2.put("assignee_id", "002");
        task2.put("task_state", "active");


        final var projectsDataFromTestTask = List.of(
            task1, task2
        );

        final var exceptedDataFromTestTask = 2;
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

        final var actualResult = employeeService.getNumberUniqueEmployeesFromMap(projectsDataFromTestTask);
        Assertions.assertEquals(exceptedDataFromTestTask, actualResult);
    }
}