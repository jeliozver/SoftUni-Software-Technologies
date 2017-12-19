package animelist.entity;

import javax.persistence.*;

@Entity
@Table(name = "animes")
public class Anime {
    private Integer id;

    private int rating;

    private String name;

    private String description;

    private String watched;

    public Anime(Integer id, int rating, String name, String description, String watched) {
        this.id = id;
        this.rating = rating;
        this.name = name;
        this.description = description;
        this.watched = watched;
    }

    public Anime() {
        int rating = this.getRating();
        String name = this.getName();
        String description = this.getDescription();
        String watched = this.getWatched();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "watched", nullable = false)
    public String getWatched() {
        return watched;
    }

    public void setWatched(String watched) {
        this.watched = watched;
    }
}
