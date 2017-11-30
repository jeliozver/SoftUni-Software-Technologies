package softuniBlog.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "articles")
public class Article {

    private Integer id;

    private String title;

    private String content;

    private Date date;

    private User author;

    public Article(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;

        this.date = new Date();
    }

    public Article () {
        this.date = new Date();
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

    @Column(name = "content", columnDefinition = "text", nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne()
    @JoinColumn(name = "authorId", nullable =  false)
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Transient
    public String getSummary() {
        return this.getContent().substring(0, this.getContent().length() / 2) + "...";
    }
}