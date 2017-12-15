package imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {
	private Integer id;

	private String name;

	private String genre;

	private String director;

	private int year;

    public Film(Integer id, String name, String genre, String director, int year) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.year = year;
    }

    public Film() {
        String name = this.getName();
        String genre = this.getGenre();
        String director = this.getDirector();
        int year = this.getYear();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "genre", nullable = false)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "director", nullable = false)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(name = "year", nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
