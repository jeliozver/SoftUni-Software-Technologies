package trainsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "trips")
public class Trip {
    private Integer id;

    private String origin;

    private String destination;

    private int business;

    private int economy;

    public Trip(Integer id, String origin, String destination, int business, int economy) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.business = business;
        this.economy = economy;
    }

    public Trip() {
        String origin = this.getOrigin();
        String destination = this.getDestination();
        int business = this.getBusiness();
        int economy = this.getEconomy();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "origin", nullable = false)
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Column(name = "destination", nullable = false)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Column(name = "business", nullable = false)
    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    @Column(name = "economy", nullable = false)
    public int getEconomy() {
        return economy;
    }

    public void setEconomy(int economy) {
        this.economy = economy;
    }
}
