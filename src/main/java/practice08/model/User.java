package practice08.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    private int id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos = new ArrayList<>();

    public User() {}

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Auto> getAutos() {
        return this.autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public void addAuto(Auto auto) {
        this.autos.add(auto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.getId() &&
                this.age == user.getAge() &&
                this.name.equals(user.getName()) &&
                Objects.equals(this.autos, user.getAutos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, autos);
    }

    @Override
    public String toString() {
        return "User {id: " + this.id + ", name: " + this.name + ", age: " + this.age + "}";
    }
}
