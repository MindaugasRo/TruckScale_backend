package lt.onemagic.TruckScale.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
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

    public void updateDetails(Contact contactDetails) {
        this.firstName = contactDetails.getFirstName();
        this.secondName = contactDetails.getSecondName();
        this.email = contactDetails.getEmail();
        this.phone1 = contactDetails.getPhone1();
        this.phone2 = contactDetails.getPhone2();
        this.street = contactDetails.getStreet();
        this.city = contactDetails.getCity();
        this.postCode = contactDetails.getPostCode();
        this.country = contactDetails.getCountry();
        // Update other fields as necessary
    }
}
