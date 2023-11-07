package com.example.activititest;

import lombok.RequiredArgsConstructor;
import org.activiti.engine.RuntimeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitService {
    private final RuntimeService runtimeService;
    public void print() {
//        List<String> process = runtimeService.getActiveActivityIds("process");
        runtimeService.createExecutionQuery().list();
        runtimeService.createProcessInstanceQuery().list()
                .stream()
                .filter(processInstance -> {
                    processInstance.getProcessVariables();
                    processInstance.
                    return true;
                }).toList();

        System.out.println("starting new process");
    }
}
