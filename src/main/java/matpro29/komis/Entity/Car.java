package matpro29.komis.Entity;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(generator = "car_sequence")
    private Long id;

    @Column
    private String brand;

    @Column
    private String description;

    @Column
    private String model;

    @Column
    private String price;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @Column
    private String year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
