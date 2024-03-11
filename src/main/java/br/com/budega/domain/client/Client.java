package br.com.budega.domain.client;

import br.com.budega.domain.address.Address;
import br.com.budega.domain.address.dto.AddressData;
import br.com.budega.domain.client.dto.RegisterClient;
import br.com.budega.domain.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Table(name = "clients")
@Entity(name = "Client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    @Column(name = "name")
    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    private String name;

    @Column(name = "email")
    @NotNull(message = "O campo email não pode ser nulo")
    @NotBlank(message = "O campo email não pode ser vazio")
    private String email;

    @Column(name = "password")
    @NotNull(message = "O campo password não pode ser nulo")
    @NotBlank(message = "O campo password não pode ser vazio")
    private String password;

    @Column(name = "telephone")
    @NotNull(message = "O campo telefone não pode ser nulo")
    @NotBlank(message = "O campo telefone não pode ser vazio")
    @Pattern(regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[0-9])[0-9]{3}\\-[0-9]{4}$")
    private String telephone;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @Column(name = "orders")
    private List<Order> orders;

    public Client(RegisterClient dados) {
        this.name = dados.name();
        this.email = dados.email();
        this.password = dados.password();
        this.telephone = dados.telephone();
        this.address = new Address(dados.address());
    }

}
