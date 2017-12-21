package lognoziroh.entity;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report {
    private Integer id;

    private String status;

    private String message;

    private String origin;

    public Report(Integer id, String status, String message, String origin) {
        this.id = id;
        this.status = status;
        this.message = message;
        this.origin = origin;
    }

    public Report() {
        String status = this.getStatus();
        String message = this.getMessage();
        String origin = this.getOrigin();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "message", nullable = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "origin", nullable = false)
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
