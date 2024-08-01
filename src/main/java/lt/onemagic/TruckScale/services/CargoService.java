package lt.onemagic.TruckScale.services;

import lt.onemagic.TruckScale.models.Cargo;
import lt.onemagic.TruckScale.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public Cargo saveCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public List<Cargo> getAllCargo() {
        return cargoRepository.findAll();
    }

    public Cargo getCargoById(long id) {
        return cargoRepository.findById(id).orElse(null);
    }

    public void deleteCargo(long id) {
        cargoRepository.deleteById(id);
    }
}
