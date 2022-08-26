package com.worker.employees.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
class EmployeeServiceImplTest {

    @Autowired EmployeeService employeeService;

    @ParameterizedTest
    @MethodSource("methodDataProvider")
    void getNumberUniqueEmployeesFromMap(
        final List<HashMap<String, String>> projectsDataFromTestTask,
        final int exceptedResult
    ) {
        final var actualResult = employeeService.getNumberUniqueEmployeesFromMap(projectsDataFromTestTask);
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    static Stream<Arguments> methodDataProvider() {
//      Data from test task:
        final var task1 = new HashMap<String, String>();
        task1.put("task_id", "1");
        task1.put("assignee_id", "001");
        task1.put("task_state", "active");

        final var task2 = new HashMap<String, String>();
        task2.put("task_id", "2");
        task2.put("assignee_id", "002");
        task2.put("task_state", "active");

        final var task3 = new HashMap<String, String>();
        task3.put("task_id", "3");
        task3.put("assignee_id", "001");
        task3.put("task_state", "active");

        final var task4 = new HashMap<String, String>();
        task4.put("task_id", "1");
        task4.put("assignee_id", "007");
        task4.put("task_state", "disabled");

//      Additional data for tests:
        final var task5 = new HashMap<String, String>();
        task5.put("task_id", "1");
        task5.put("assignee_id", "009");
        task5.put("task_state", "active");

        final var task6 = new HashMap<String, String>();
        task6.put("task_id", "1");
        task6.put("assignee_id", "001");
        task6.put("task_state", "disabled");

        final var exceptedDataFromTestTask = 2;
        final var projectsDataFromTestTask = List.of(
            task1, task2, task3, task4
        );

        final var exceptedData2 = 3;
        final var projectsData2 = List.of(
            task1, task2, task3, task4, task5
        );

        final var exceptedData3 = 3;
        final var projectsData3 = List.of(
            task1, task2, task3, task4, task5, task6
        );

        return Stream.of(
            arguments(projectsDataFromTestTask, exceptedDataFromTestTask),
            arguments(projectsData2, exceptedData2),
            arguments(projectsData3, exceptedData3)
        );
    }
}