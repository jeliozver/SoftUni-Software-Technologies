package projectrider.entity;

import javax.persistence.*;

@Entity
@Table(name = "projets")
public class Project {
    private Integer id;

    private String title;

    private String description;

    private long budget;

    public Project(Integer id, String title, String description, long budget) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.budget = budget;
    }

    public Project() {
        String title = this.getTitle();
        String description = this.getDescription();
        long budget = this.getBudget();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "budget", nullable = false)
    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }
}
