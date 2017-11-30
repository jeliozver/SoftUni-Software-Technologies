package softuniBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuniBlog.entity.Article;
import softuniBlog.repository.ArticleRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model model) {

        List<Article> articles = this.articleRepository.findAll();

        Comparator<Article> date = Comparator.comparing(Article::getDate).reversed();
        articles.sort(date);

        List<Article> temp;
        temp = articles
                .stream()
                .limit(6)
                .collect(Collectors.toList());

        articles = temp;

        model.addAttribute("view", "home/index");
        model.addAttribute("articles", articles);

        return "base-layout";
    }
}