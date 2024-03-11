package br.com.budega.domain.product;

import br.com.budega.domain.order.Order;
import br.com.budega.domain.product.productCategory.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "Produto")
@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "mark")
    @NotNull(message = "O campo marca não pode ser nulo")
    @NotBlank(message = "O campo marca não pode ser vazio")
    private String mark;

    @Column(name = "name")
    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    private String name;

    @Column(name = "price")
    @NotNull(message = "O campo preço não pode ser nulo")
    @NotBlank(message = "O campo preço não pode ser vazio")
    private Double price;

    @Column(name = "stock_quantity")
    @NotNull(message = "O campo quantidade em estoque não pode ser nulo")
    @NotBlank(message = "O campo quantidade em estoque não pode ser vazio")
    private Integer stockQuantity;

    @Column(name = "category")
    @NotNull(message = "O campo categoria não pode ser nulo")
    @NotBlank(message = "O campo categoria não pode ser vazio")
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    @Column(name = "orders")
    private List<Order> orders;

}
