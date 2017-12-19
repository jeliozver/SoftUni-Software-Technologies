package animelist.controller;

import animelist.entity.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import animelist.bindingModel.AnimeBindingModel;
import animelist.repository.AnimeRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class AnimeController {

	private final AnimeRepository animeRepository;

	@Autowired
	public AnimeController(AnimeRepository animeRepository) {
		this.animeRepository = animeRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Anime> animes = animeRepository.findAll();

		Comparator<Anime> rating = Comparator.comparing(Anime::getRating);
		animes.sort(rating);

        ArrayList<Anime> temp = new ArrayList<>(animes);
		animes = temp;

		model.addAttribute("animes", animes);
		model.addAttribute("view", "anime/index");

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "anime/create");

		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, AnimeBindingModel animeBindingModel) {
        if (animeBindingModel == null) {
            model.addAttribute("view", "anime/create");

            return "base-layout";
        }

        if (isFormInvalid(animeBindingModel)) {
            model.addAttribute("view", "anime/create");

            return "base-layout";
        }

        Anime anime = new Anime();

        anime.setRating(Integer.parseInt(animeBindingModel.getRating()));
        anime.setName(animeBindingModel.getName());
        anime.setDescription(animeBindingModel.getDescription());
        anime.setWatched(animeBindingModel.getWatched());

        animeRepository.saveAndFlush(anime);

        return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
        Anime anime = animeRepository.findOne(id);

        if (anime == null) {
            return "redirect:/";
        }

        model.addAttribute("view", "anime/delete");
        model.addAttribute("anime", anime);

        return "base-layout";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(@PathVariable int id) {
        Anime anime = animeRepository.findOne(id);

        if (anime == null) {
            return "redirect:/";
        }

        animeRepository.delete(anime);
        animeRepository.flush();

        return "redirect:/";
	}

    private boolean isFormInvalid (AnimeBindingModel animeBindingModel){
        try {
            return animeBindingModel.getName().equals("")
                    || animeBindingModel.getDescription().equals("")
                    || animeBindingModel.getWatched().equals("")
                    || Integer.parseInt(animeBindingModel.getRating()) <= 0;
        } catch (Exception e) {
            return true;
        }
    }
}
