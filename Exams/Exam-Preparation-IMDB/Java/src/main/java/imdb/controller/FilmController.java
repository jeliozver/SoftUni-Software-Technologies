package imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import imdb.bindingModel.FilmBindingModel;
import imdb.entity.Film;
import imdb.repository.FilmRepository;
import java.util.List;

@Controller
public class FilmController {

	private final FilmRepository filmRepository;

	@Autowired
	public FilmController(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Film> films = filmRepository.findAll();

		model.addAttribute("films", films);
		model.addAttribute("view", "film/index");

		return  "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "film/create");

		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(FilmBindingModel filmBindingModel) {

		if (filmBindingModel == null) {
			return "redirect:/";
		}

		if (isFormInvalid(filmBindingModel))
		{
			return "redirect:/";
		}

		Film film = new Film();

		film.setName(filmBindingModel.getName());
		film.setGenre(filmBindingModel.getGenre());
		film.setDirector(filmBindingModel.getDirector());
		film.setYear(Integer.parseInt(filmBindingModel.getYear()));

		filmRepository.saveAndFlush(film);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		Film film = filmRepository.findOne(id);

		if (film == null) {
			return "redirect:/";
		}

		model.addAttribute("view", "film/edit");
		model.addAttribute("film", film);

		return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(@PathVariable int id, FilmBindingModel filmBindingModel) {
		if (!this.filmRepository.exists(id)) {
			return "redirect:/";
		}

		if (isFormInvalid(filmBindingModel))
		{
			return "redirect:/";
		}

		Film film = this.filmRepository.findOne(id);

		film.setName(filmBindingModel.getName());
		film.setGenre(filmBindingModel.getGenre());
		film.setDirector(filmBindingModel.getDirector());
		film.setYear(Integer.parseInt(filmBindingModel.getYear()));

		filmRepository.saveAndFlush(film);

		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		Film film = filmRepository.findOne(id);

		if (film == null) {
			return "redirect:/";
		}

		model.addAttribute("view", "film/delete");
		model.addAttribute("film", film);

		return "base-layout";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(@PathVariable int id) {
		Film film = filmRepository.findOne(id);

		if (film == null) {
			return "redirect:/";
		}

		filmRepository.delete(film);
		filmRepository.flush();

		return "redirect:/";
	}

	private boolean isFormInvalid (FilmBindingModel filmBindingModel){
		try {
			return filmBindingModel.getName().equals("")
					|| filmBindingModel.getGenre().equals("")
					|| filmBindingModel.getDirector().equals("")
					|| Integer.parseInt(filmBindingModel.getYear()) < 1900;
		} catch (Exception e) {
			return true;
		}
	}
}
