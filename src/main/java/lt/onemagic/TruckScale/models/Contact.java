package lt.onemagic.TruckScale.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String secondName;

    private String email;

    private String phone1;

    private String phone2;

    private String street;

    private String city;

    private String postCode;

    private String country;
}
