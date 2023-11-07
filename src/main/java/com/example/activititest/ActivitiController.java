package com.example.activititest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/activiti")
public class ActivitiController {

    private final RuntimeService runtimeService;
    private final TaskService taskService;
    @GetMapping
    public void start() {
        Map<String, Object> vars = Map.of("ReviewUser", "sanya");

        runtimeService.startProcessInstanceByKey("process", vars);
        log.info("Process count {}", runtimeService.createProcessInstanceQuery().count());
    }

    @GetMapping("/A")
    public void a() {
        List<Task> taskList = taskService.createTaskQuery().list();
        Task task = taskList.stream().findAny().get();

        task.getFormKey();
//        runtimeService.startProcessInstanceByKey("process");
        log.info("Process count {}", runtimeService.createProcessInstanceQuery().count());
    }

    @GetMapping("/B")
    public void b() {
//        runtimeService.startProcessInstanceByKey("process");
        log.info("Process count {}", runtimeService.createProcessInstanceQuery().count());
    }
}
