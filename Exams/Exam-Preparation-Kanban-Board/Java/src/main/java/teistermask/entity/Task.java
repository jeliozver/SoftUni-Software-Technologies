package teistermask.entity;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    private Integer id;

	private String title;

	private String status;

    public Task(Integer id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public Task() {
        String title = this.getTitle();
        String status = this.getStatus();
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

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
