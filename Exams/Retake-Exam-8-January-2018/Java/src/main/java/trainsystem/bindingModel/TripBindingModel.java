package trainsystem.bindingModel;

public class TripBindingModel {
    private String origin;

    private String destination;

    private String business;

    private String economy;

    public TripBindingModel(String origin, String destination, String business, String economy) {
        this.origin = origin;
        this.destination = destination;
        this.business = business;
        this.economy = economy;
    }
    public TripBindingModel() {

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getEconomy() {
        return economy;
    }

    public void setEconomy(String economy) {
        this.economy = economy;
    }
}