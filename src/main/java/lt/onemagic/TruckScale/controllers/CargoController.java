package lt.onemagic.TruckScale.controllers;

import lt.onemagic.TruckScale.models.Cargo;
import lt.onemagic.TruckScale.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping("/save")
    public ResponseEntity<Cargo> saveCargo(@RequestBody Cargo cargo) {
        Cargo savedCargo = cargoService.saveCargo(cargo);
        return ResponseEntity.ok(savedCargo);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Cargo>> getAllCargo() {
        List<Cargo> cargoList = cargoService.getAllCargo();
        return ResponseEntity.ok(cargoList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable long id) {
        Cargo cargo = cargoService.getCargoById(id);
        return ResponseEntity.ok(cargo);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable long id) {
        cargoService.deleteCargo(id);
        return ResponseEntity.noContent().build();
    }
}