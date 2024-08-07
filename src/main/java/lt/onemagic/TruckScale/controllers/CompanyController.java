package lt.onemagic.TruckScale.controllers;

import lt.onemagic.TruckScale.models.Company;
import lt.onemagic.TruckScale.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/save")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        Company savedCompany = companyService.saveCompany(company);
        return ResponseEntity.ok(savedCompany);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companyList = companyService.getAllCompanies();
        return ResponseEntity.ok(companyList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id) {
        Company company = companyService.getCompanyById(id);
        return ResponseEntity.ok(company);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}