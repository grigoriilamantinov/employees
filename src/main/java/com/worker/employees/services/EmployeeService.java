package com.worker.employees.services;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {
    int getNumberUniqueEmployeesFromMap(List<HashMap<String, String>> projectsTasks);
}
