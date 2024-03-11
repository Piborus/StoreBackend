package br.com.budega.domain.address;

import br.com.budega.domain.address.dto.AddressData;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(name = "street")
    private String street;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "zip_code")
    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX")
    private String zipCode;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    public Address(AddressData dados) {
        this.street = dados.street();
        this.neighborhood = dados.neighborhood();
        this.zipCode = dados.zipCode();
        this.number = dados.number();
        this.city = dados.city();
        this.state = dados.state();
        this.country = dados.country();

    }
}
