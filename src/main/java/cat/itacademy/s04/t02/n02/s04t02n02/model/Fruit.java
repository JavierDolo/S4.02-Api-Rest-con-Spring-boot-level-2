package cat.itacademy.s04.t02.n02.s04t02n02.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "quantity_kilos")
    private int quantityKilos;

    public Fruit() { }

    public Fruit(String name, int quantityKilos) { this.name = name; this.quantityKilos = quantityKilos; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantityKilos() { return quantityKilos; }
    public void setQuantityKilos(int quantityKilos) { this.quantityKilos = quantityKilos; }
}
