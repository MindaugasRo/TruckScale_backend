package lt.onemagic.TruckScale.bootstrap;

import lombok.AllArgsConstructor;
import lombok.Getter;
//import lt.onemagic.TruckScale.services.CargoService;
//import lt.onemagic.TruckScale.services.CompanyService;
//import lt.onemagic.TruckScale.services.ContactService;
import lt.onemagic.TruckScale.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(BootStrapData.class);
    private final UserService userService;
//    private final CompanyService companyService;
//    private final ContactService contactService;


    @Override
    public void run(String... args) throws Exception {
        logger.info("Application has started.");
//        companyService.generateAndSaveCompanies(10);
//        logger.info("10 Company records have been generated and saved.");
//        contactService.generateAndSaveContacts(120);
//        logger.info("10 Company records have been generated and saved.");
    }
}


