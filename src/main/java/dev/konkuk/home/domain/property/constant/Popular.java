package dev.konkuk.home.domain.property.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Embeddable
public class Popular {

    private String  popularTitle;

    @Lob
    private String  popularDescription;

    private String  popularURL;


}
