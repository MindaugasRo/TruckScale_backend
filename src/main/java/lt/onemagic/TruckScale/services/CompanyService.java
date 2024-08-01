package lt.onemagic.TruckScale.services;

import lt.onemagic.TruckScale.models.Company;
import lt.onemagic.TruckScale.repositories.CompanyRepository;
//import lt.onemagic.TruckScale.utils.CompanyDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public void deleteCompany(long id) {
        companyRepository.deleteById(id);
    }

//    public void generateAndSaveCompanies(int count) {
//        List<Company> companies = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            companies.add(CompanyDataGenerator.generateCompany());
//        }
//        companyRepository.saveAll(companies);
//    }
}
