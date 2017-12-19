package animelist.bindingModel;

public class AnimeBindingModel {
    private String rating;

    private String name;

    private String description;

    private String watched;

    public AnimeBindingModel(String rating, String name, String description, String watched) {
        this.rating = rating;
        this.name = name;
        this.description = description;
        this.watched = watched;
    }

    public AnimeBindingModel() {

    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWatched() {
        return watched;
    }

    public void setWatched(String watched) {
        this.watched = watched;
    }
}
