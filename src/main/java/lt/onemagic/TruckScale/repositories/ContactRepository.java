package lt.onemagic.TruckScale.repositories;

import lt.onemagic.TruckScale.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("SELECT c FROM Contact c WHERE " +
            "(:firstName IS NULL OR c.firstName LIKE %:firstName%) AND " +
            "(:lastName IS NULL OR c.lastName LIKE %lastName%) AND " +
            "(:city IS NULL OR c.city LIKE %:city%) AND " +
            "(:country IS NULL OR c.country LIKE %:country%) AND " +
            "(:company IS NULL OR c.company LIKE %:company%)")
    List<Contact> filterContacts(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("city") String city,
            @Param("country") String country,
            @Param("company") String company);
}
