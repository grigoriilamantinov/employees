package com.worker.employees.dto;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum TaskState {
    ACTIVE("active"),
    DISABLED("disabled");

    private final String state;

    public static TaskState getState(final String state) {
        return Arrays.stream(TaskState.values())
            .filter(taskState -> taskState.state.equals(state))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Unknown task state"));
    }
}
