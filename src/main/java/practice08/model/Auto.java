package practice08.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "autos")
public class Auto {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autos_seq")
    @SequenceGenerator(name = "autos_seq", sequenceName = "autos_seq", allocationSize = 1)
    private int id;
    private String model;
    private String colour;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto() {}

    public Auto(String model, String colour) {
        this.model = model;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return this.id == auto.getId() &&
                this.model.equals(auto.getModel()) &&
                this.colour.equals(auto.getColour()) &&
                user.equals(auto.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, colour, user);
    }

    @Override
    public String toString() {
        return "Auto {id: " + this.id + ", model: " + this.model + ", colour: " + this.colour + ", user: " + this.user + "}";
    }
}
