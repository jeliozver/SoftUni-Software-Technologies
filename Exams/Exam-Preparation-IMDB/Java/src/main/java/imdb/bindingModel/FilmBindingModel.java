package imdb.bindingModel;

public class FilmBindingModel {
    private String name;

    private String genre;

    private String director;

    private String year;

    public FilmBindingModel(String name, String genre, String director, String year) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.year = year;
    }

    public FilmBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
