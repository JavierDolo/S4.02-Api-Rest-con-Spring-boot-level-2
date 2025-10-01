package cat.itacademy.s04.t02.n02.s04t02n02.dto;

public class FruitResponse {
    private Long id;
    private String name;
    private int quantityKilos;

    public FruitResponse(Long id, String name, int quantityKilos) { this.id = id; this.name = name; this.quantityKilos = quantityKilos; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getQuantityKilos() { return quantityKilos; }
}
