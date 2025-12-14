package pl.edu.vistula.task2_rest_api.product.api.response;

public class ProductResponse {

    private Long id;
    private String name;

    public ProductResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}
