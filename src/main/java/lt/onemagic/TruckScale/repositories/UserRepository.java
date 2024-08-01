package lt.onemagic.TruckScale.repositories;

import lt.onemagic.TruckScale.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
