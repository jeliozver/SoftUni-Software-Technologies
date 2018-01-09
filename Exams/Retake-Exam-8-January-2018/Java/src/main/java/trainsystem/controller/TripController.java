package trainsystem.controller;

import trainsystem.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import trainsystem.bindingModel.TripBindingModel;
import trainsystem.repository.TripRepository;

import java.util.List;

@Controller
public class TripController {
	private final TripRepository tripRepository;

	@Autowired
	public TripController(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
        List<Trip> trips = tripRepository.findAll();

        model.addAttribute("trips", trips);
        model.addAttribute("view", "trip/index");

        return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
        model.addAttribute("view", "trip/create");

        return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, TripBindingModel tripBindingModel) {
        if (tripBindingModel == null) {
            model.addAttribute("view", "trip/create");

            return "base-layout";
        }

        if (isFormInvalid(tripBindingModel)) {
            model.addAttribute("view", "trip/create");

            return "base-layout";
        }

        Trip trip = new Trip();

        trip.setOrigin(tripBindingModel.getOrigin());
        trip.setDestination(tripBindingModel.getDestination());
        trip.setBusiness(Integer.parseInt(tripBindingModel.getBusiness()));
        trip.setEconomy(Integer.parseInt(tripBindingModel.getEconomy()));
        
        tripRepository.saveAndFlush(trip);

        return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
        Trip trip = tripRepository.findOne(id);

        if (trip == null) {
            return "redirect:/";
        }

        model.addAttribute("view", "trip/edit");
        model.addAttribute("trip", trip);

        return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(@PathVariable int id, TripBindingModel tripBindingModel) {
        if (!this.tripRepository.exists(id)) {
            return "redirect:/";
        }

        if (isFormInvalid(tripBindingModel))
        {
            return "redirect:/";
        }

        Trip trip = this.tripRepository.findOne(id);

        trip.setOrigin(tripBindingModel.getOrigin());
        trip.setDestination(tripBindingModel.getDestination());
        trip.setBusiness(Integer.parseInt(tripBindingModel.getBusiness()));
        trip.setEconomy(Integer.parseInt(tripBindingModel.getEconomy()));

        tripRepository.saveAndFlush(trip);

        return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
        Trip trip = tripRepository.findOne(id);

        if (trip == null) {
            return "redirect:/";
        }

        model.addAttribute("view", "trip/delete");
        model.addAttribute("trip", trip);

        return "base-layout";
	}

	@PostMapping("/delete/{id}")
	public String deleteProcess(@PathVariable int id) {
        Trip trip = tripRepository.findOne(id);

        if (trip == null) {
            return "redirect:/";
        }

        tripRepository.delete(trip);
        tripRepository.flush();

        return "redirect:/";
	}

    private boolean isFormInvalid (TripBindingModel tripBindingModel){
        try {
            return tripBindingModel.getOrigin().equals("")
                    || tripBindingModel.getDestination().equals("")
                    || Integer.parseInt(tripBindingModel.getBusiness()) < 0
                    || Integer.parseInt(tripBindingModel.getEconomy()) < 0;
        } catch (Exception e) {
            return true;
        }
    }
}
