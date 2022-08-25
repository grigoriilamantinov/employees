package com.worker.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ProjectsTask {
    private Long taskId;
    private Long assigneeId;
    private TaskState taskState;
}
