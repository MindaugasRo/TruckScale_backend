package lt.onemagic.TruckScale.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String status;

    private String companyCode;

    private String vatCode;

    private String street;

    private String city;

    private String postCode;

    private String country;

    private String email;

    private String phone1;

    private String phone2;

    private String additionalInfo;
}