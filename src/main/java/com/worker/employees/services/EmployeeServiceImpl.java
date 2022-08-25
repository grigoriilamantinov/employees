package com.worker.employees.services;

import com.worker.employees.dto.ProjectsTask;
import com.worker.employees.dto.TaskState;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl {
    private static final String TASK_ID = "task_id";
    private static final String ASSIGNEE_ID = "assignee_id";
    private static final String TASK_STATE = "task_state";

    public int getNumberUniqueEmployeesFromMap(List<HashMap<String, String>> projectsTasks) {
        return this.getProjectTasks(projectsTasks).stream()
            .filter(task -> task.getTaskState() == TaskState.ACTIVE)
            .map(ProjectsTask::getAssigneeId)
            .collect(Collectors.toSet())
            .size();
    }

    private List<ProjectsTask> getProjectTasks(List<HashMap<String, String>> inputData) {
        return inputData.stream().map(it -> ProjectsTask
            .builder()
            .taskId(Long.parseLong(it.get(TASK_ID)))
            .assigneeId(Long.parseLong(it.get(ASSIGNEE_ID)))
            .taskState(TaskState.getStatus(it.get(TASK_STATE)))
            .build()
        ).collect(Collectors.toList());
    }
}
