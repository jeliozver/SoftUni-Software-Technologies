package teistermask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import teistermask.bindingModel.TaskBindingModel;
import teistermask.entity.Task;
import teistermask.repository.TaskRepository;
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
		List<Task> openTasks = taskRepository
				.findAllByStatus("Open");
		List<Task> inProgressTasks = taskRepository
				.findAllByStatus("In Progress");
		List<Task> finishedTasks = taskRepository
				.findAllByStatus("Finished");

		model.addAttribute("openTasks", openTasks);
		model.addAttribute("inProgressTasks", inProgressTasks);
		model.addAttribute("finishedTasks", finishedTasks);
		model.addAttribute("view", "task/index");

		return  "base-layout";
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

		if (isFormInvalid(taskBindingModel))
		{
			return "redirect:/";
		}

		Task task = new Task();
		task.setTitle(taskBindingModel.getTitle());
		task.setStatus(taskBindingModel.getStatus());

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
	public String editProcess(@PathVariable int id, TaskBindingModel taskBindingModel) {
		if (!this.taskRepository.exists(id)) {
			return "redirect:/";
		}

		if (isFormInvalid(taskBindingModel))
		{
			return "redirect:/";
		}

		Task task = this.taskRepository.findOne(id);
		task.setTitle(taskBindingModel.getTitle());
		task.setStatus(taskBindingModel.getStatus());

		taskRepository.saveAndFlush(task);

		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
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

	private boolean isFormInvalid (TaskBindingModel taskBindingModel){

			return taskBindingModel.getTitle().equals("")
					|| taskBindingModel.getStatus().equals("");
	}
}
