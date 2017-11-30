package softuniBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import softuniBlog.bindingModel.ArticleBindingModel;
import softuniBlog.entity.Article;
import softuniBlog.entity.User;
import softuniBlog.repository.ArticleRepository;
import softuniBlog.repository.UserRepository;

import java.util.Date;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    private boolean isUserAuthorOrAdmin(Article article) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        User userEntity = this.userRepository.findByEmail(user.getUsername());

        return userEntity.isAdmin() || userEntity.isAuthor(article);
    }

    @GetMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String createView(Model model) {
        model.addAttribute("view", "article/create");

        return "base-layout";
    }

    @PostMapping("/article/create")
    @PreAuthorize("isAuthenticated()")
    public String createAction(ArticleBindingModel model) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User userEntity = this.userRepository.findByEmail(userDetails.getUsername());

        Article articleEntity = new Article(
                model.getTitle(),
                model.getContent(),
                userEntity
        );

        this.articleRepository.saveAndFlush(articleEntity);

        return "redirect:/";
    }

    @GetMapping("/article/{id}")
    public String detailsView(Model model, @PathVariable Integer id) {
        if (!this.articleRepository.exists(id)) {
            return  "redirect:/";
        }

        if (!(SecurityContextHolder.getContext().getAuthentication()
                instanceof AnonymousAuthenticationToken)) {
            UserDetails principal = (UserDetails) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();

            User entityUser = this.userRepository
                    .findByEmail(principal.getUsername());

            model.addAttribute("user", entityUser);
        }

        Article article = this.articleRepository.findOne(id);

        model.addAttribute("view", "article/details");
        model.addAttribute("article", article);

        return "base-layout";

    }

    @GetMapping("article/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editView(@PathVariable Integer id, Model model) {
        if (!this.articleRepository.exists(id)) {
            return "redirect:/";
        }

        Article article = this.articleRepository.findOne(id);

        if (!isUserAuthorOrAdmin(article)) {
            return  "redirect:/article/" + id;
        }

        model.addAttribute("view", "article/edit");
        model.addAttribute("article", article);

        return "base-layout";
    }

    @PostMapping("article/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String editAction(@PathVariable Integer id, ArticleBindingModel articleBindingModel) {
        if (!this.articleRepository.exists(id)) {
            return "redirect:/";
        }

        Article article = this.articleRepository.findOne(id);

        if (!isUserAuthorOrAdmin(article)) {
            return  "redirect:/article/" + id;
        }

        article.setContent(articleBindingModel.getContent());
        article.setTitle(articleBindingModel.getTitle());
        article.setDate(new Date());

        this.articleRepository.saveAndFlush(article);

        return "redirect:/article/" + article.getId();
    }

    @GetMapping("article/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteView(@PathVariable Integer id, Model model) {
        if (!this.articleRepository.exists(id)) {
            return  "redirect:/";
        }

        Article article = this.articleRepository.findOne(id);

        if (!isUserAuthorOrAdmin(article)) {
            return  "redirect:/article/" + id;
        }

        model.addAttribute("view", "article/delete");
        model.addAttribute("article", article);

        return "base-layout";
    }

    @PostMapping("article/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteAction(@PathVariable Integer id) {
        if (!this.articleRepository.exists(id)) {
            return  "redirect:/";
        }

        Article article = this.articleRepository.findOne(id);

        if (!isUserAuthorOrAdmin(article)) {
            return  "redirect:/article/" + id;
        }

        this.articleRepository.delete(article);

        return  "redirect:/";
    }
}