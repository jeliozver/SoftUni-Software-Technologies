package shoppinglist.bindingModel;

public class ProductBindingModel {
    private String priority;

    private String name;

    private String quantity;

    private String status;

    public ProductBindingModel(String priority, String name, String quantity, String status) {
        this.priority = priority;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
    }

    public ProductBindingModel() {

    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
