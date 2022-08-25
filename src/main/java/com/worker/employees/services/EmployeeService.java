package com.worker.employees.services;

import com.worker.employees.dto.ProjectsTask;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {


    int getNumberUniqueEmployeesFromList (List<ProjectsTask> projectsTasks);
}
