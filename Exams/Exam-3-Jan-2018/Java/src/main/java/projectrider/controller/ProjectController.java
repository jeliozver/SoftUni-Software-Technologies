package projectrider.controller;

import projectrider.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import projectrider.bindingModel.ProjectBindingModel;
import projectrider.repository.ProjectRepository;

import java.util.List;

@Controller
public class ProjectController {
	private final ProjectRepository projectRepository;

	@Autowired
	public ProjectController(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Project> projects = projectRepository.findAll();

		model.addAttribute("projects", projects);
		model.addAttribute("view", "project/index");

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "project/create");

		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, ProjectBindingModel projectBindingModel) {
		if (projectBindingModel == null) {
			model.addAttribute("view", "project/create");

			return "base-layout";
		}

		if (isFormInvalid(projectBindingModel)) {
			model.addAttribute("view", "project/create");

			return "base-layout";
		}

		Project project = new Project();

		project.setTitle(projectBindingModel.getTitle());
		project.setDescription(projectBindingModel.getDescription());
		project.setBudget(Long.parseLong(projectBindingModel.getBudget()));

		projectRepository.saveAndFlush(project);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
        Project project = projectRepository.findOne(id);

        if (project == null) {
            return "redirect:/";
        }

        model.addAttribute("view", "project/edit");
        model.addAttribute("project", project);

        return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(@PathVariable int id, Model model, ProjectBindingModel projectBindingModel) {
        if (!this.projectRepository.exists(id)) {
            return "redirect:/";
        }

        if (isFormInvalid(projectBindingModel))
        {
            return "redirect:/";
        }

        Project project = this.projectRepository.findOne(id);

        project.setTitle(projectBindingModel.getTitle());
        project.setDescription(projectBindingModel.getDescription());
        project.setBudget(Long.parseLong(projectBindingModel.getBudget()));

        projectRepository.saveAndFlush(project);

        return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
        Project project = projectRepository.findOne(id);

        if (project == null) {
            return "redirect:/";
        }

        model.addAttribute("view", "project/delete");
        model.addAttribute("project", project);

        return "base-layout";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(@PathVariable int id, ProjectBindingModel projectBindingModel) {
        Project project = projectRepository.findOne(id);

        if (project == null) {
            return "redirect:/";
        }

        projectRepository.delete(project);
        projectRepository.flush();

        return "redirect:/";
	}

	private boolean isFormInvalid (ProjectBindingModel projectBindingModel){
		try {
			return projectBindingModel.getTitle().equals("")
					|| projectBindingModel.getDescription().equals("")
					|| Long.parseLong(projectBindingModel.getBudget()) < 0;
		} catch (Exception e) {
			return true;
		}
	}
}
