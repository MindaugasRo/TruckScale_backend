package lt.onemagic.TruckScale.repositories;

import lt.onemagic.TruckScale.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}