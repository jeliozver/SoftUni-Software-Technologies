package projectrider.bindingModel;

public class ProjectBindingModel {

    private String title;

    private String description;

    private String budget;

    public ProjectBindingModel(String title, String description, String budget) {
        this.title = title;
        this.description = description;
        this.budget = budget;
    }

    public ProjectBindingModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}
