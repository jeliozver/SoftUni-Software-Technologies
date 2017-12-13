package todolist.entity;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

	private Integer id;

	private String title;

	private String comments;

    public Task(Integer id, String title, String comments) {
        this.id = id;
        this.title = title;
        this.comments = comments;
    }

    public Task() {
        String title = this.getTitle();
        String comments = this.getComments();
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

    @Column(name = "comments", nullable = false)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
