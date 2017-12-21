package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import todolist.bindingModel.TaskBindingModel;
import todolist.entity.Task;
import todolist.repository.TaskRepository;
import java.util.List;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Task> tasks = taskRepository.findAll();

        model.addAttribute("tasks", tasks);
        model.addAttribute("view", "task/index");

        return "base-layout";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("view", "task/create");

        return "base-layout";
    }

    @PostMapping("/create")
    public String createProcess(TaskBindingModel taskBindingModel) {
        if (taskBindingModel == null) {
            return "redirect:/";
        }

        if (taskBindingModel.getTitle().equals("") ||
                taskBindingModel.getComments().equals("")){
            return "redirect:/";
        }

        Task task = new Task();

        task.setComments(taskBindingModel.getComments());
        task.setTitle(taskBindingModel.getTitle());

        taskRepository.saveAndFlush(task);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Task task = taskRepository.findOne(id);

        if (task == null) {
            return "redirect:/";
        }

        model.addAttribute("view", "task/edit");
        model.addAttribute("task", task);

        return "base-layout";
    }

    @PostMapping("/edit/{id}")
    public String editProcess(TaskBindingModel taskBindingModel, @PathVariable int id) {
        Task task = taskRepository.findOne(id);

        if (task == null) {
            return "redirect:/";
        }

        if (taskBindingModel.getTitle().equals("") || taskBindingModel.getComments().equals("")) {
            return "redirect:/";
        }

        task.setComments(taskBindingModel.getComments());
        task.setTitle(taskBindingModel.getTitle());

        taskRepository.saveAndFlush(task);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
        Task task = taskRepository.findOne(id);

        if (task == null) {
            return "redirect:/";
        }

        model.addAttribute("view", "task/delete");
        model.addAttribute("task", task);

        return "base-layout";
    }

    @PostMapping("/delete/{id}")
    public String deleteProcess(@PathVariable int id) {
        Task task = taskRepository.findOne(id);

        if (task == null) {
            return "redirect:/";
        }

        taskRepository.delete(task);
        taskRepository.flush();

        return "redirect:/";
    }
}
