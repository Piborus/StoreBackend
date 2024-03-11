package br.com.budega.domain.address.dto;

public record AddressData(
    String street,
    String neighborhood,
    String zipCode,
    String number,
    String city,
    String state,
    String country

) {
}
