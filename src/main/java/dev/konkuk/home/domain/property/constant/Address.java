package dev.konkuk.home.domain.property.constant;


import lombok.*;

import javax.persistence.Embeddable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Address {

    private String jibunAddress;

    private String address1;

    private String address2;

    private String address3;

    public String getFullAddress() {
        return String.format("%s %s %s", this.address1, this.address2, this.address3);
    }

    public String getMiddleAddress() {
        return String.format("%s %s", this.address2, this.address3);

    }

    public Address(String address2) {
        this.address2 = address2;
    }
}
