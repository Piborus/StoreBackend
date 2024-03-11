package br.com.budega.domain.client.dto;

import br.com.budega.domain.address.dto.AddressData;
import jakarta.validation.Valid;

public record RegisterClient(
        String name,
        String email,
        String password,
        String telephone,
        @Valid
        AddressData address

) {
}
