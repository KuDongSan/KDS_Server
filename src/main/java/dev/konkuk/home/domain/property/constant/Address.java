package dev.konkuk.home.domain.property.constant;


import lombok.*;

import javax.persistence.Embeddable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Address {

    private String address1;

    private String address2;

    private String address3;

}
