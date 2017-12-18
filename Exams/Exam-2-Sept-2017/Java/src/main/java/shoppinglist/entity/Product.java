package shoppinglist.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	private Integer id;

	private int priority;

	private String name;

	private int quantity;

	private String status;

    public Product(Integer id, int priority, String name, int quantity, String status) {
        this.id = id;
        this.priority = priority;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
    }

    public Product() {
        int priority = this.getPriority();
        String name = this.getName();
        int quantity = this.getQuantity();
        String status = this.getStatus();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "priority", nullable = false)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
