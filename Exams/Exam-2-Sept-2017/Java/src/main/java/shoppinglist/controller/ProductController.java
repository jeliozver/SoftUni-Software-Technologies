package shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shoppinglist.bindingModel.ProductBindingModel;
import shoppinglist.entity.Product;
import shoppinglist.repository.ProductRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

	private final ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = productRepository.findAll();

		Comparator<Product> priority = Comparator.comparing(Product::getPriority);
		products.sort(priority);

		List<Product> temp;
		temp = products.stream().collect(Collectors.toList());

		products = temp;

		model.addAttribute("products", products);
		model.addAttribute("view", "product/index");

		return "base-layout";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "product/create");

		return "base-layout";
	}

	@PostMapping("/create")
	public String createProcess(Model model, ProductBindingModel productBindingModel) {
		if (productBindingModel == null) {
			model.addAttribute("view", "product/create");

			return "base-layout";
		}

		if (isFormInvalid(productBindingModel)) {
			model.addAttribute("view", "product/create");

			return "base-layout";
		}

		Product product = new Product();

		product.setPriority(Integer.parseInt(productBindingModel.getPriority()));
		product.setName(productBindingModel.getName());
		product.setQuantity(Integer.parseInt(productBindingModel.getQuantity()));
		product.setStatus(productBindingModel.getStatus());

		productRepository.saveAndFlush(product);

		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		Product product = productRepository.findOne(id);

		if (product == null) {
			return "redirect:/";
		}

		model.addAttribute("view", "product/edit");
		model.addAttribute("product", product);

		return "base-layout";
	}

	@PostMapping("/edit/{id}")
	public String editProcess(@PathVariable int id, ProductBindingModel productBindingModel) {
		if (!this.productRepository.exists(id)) {
			return "redirect:/";
		}

		if (isFormInvalid(productBindingModel))
		{
			return "redirect:/";
		}

		Product product = this.productRepository.findOne(id);

		product.setPriority(Integer.parseInt(productBindingModel.getPriority()));
		product.setName(productBindingModel.getName());
		product.setQuantity(Integer.parseInt(productBindingModel.getQuantity()));
		product.setStatus(productBindingModel.getStatus());

		productRepository.saveAndFlush(product);

		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
	    Product product = productRepository.findOne(id);

	    if (product == null) {
	        return "redirect:/";
        }

        model.addAttribute("view", "product/delete");
        model.addAttribute("product", product);

        return "base-layout";
    }

    @PostMapping("/delete/{id}")
    public String deleteProcess(@PathVariable int id) {
        Product product = productRepository.findOne(id);

        if (product == null) {
            return "redirect:/";
        }

        productRepository.delete(product);
        productRepository.flush();

        return "redirect:/";
    }

	private boolean isFormInvalid (ProductBindingModel productBindingModel){
		try {
			return productBindingModel.getName().equals("")
					|| productBindingModel.getStatus().equals("")
					|| Integer.parseInt(productBindingModel.getPriority()) < 0
					|| Integer.parseInt(productBindingModel.getQuantity()) < 0;
		} catch (Exception e) {
			return true;
		}
	}
}
