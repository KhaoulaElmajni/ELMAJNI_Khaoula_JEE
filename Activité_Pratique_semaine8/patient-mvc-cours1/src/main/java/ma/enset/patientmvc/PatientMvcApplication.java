package ma.enset.patientmvc;

import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;
import ma.enset.patientmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }

    @Bean //au démarrage crée moi un PasswordEncoder et tu le place dans context
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"khaoula",new Date(),false,12));
            patientRepository.save(new Patient(null,"Ahmed",new Date(),true,102));
            patientRepository.save(new Patient(null,"Ali",new Date(),false,9));
            patientRepository.save(new Patient(null,"Zakaria",new Date(),true,56));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });

        };
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveNewUser("khaoula","1234","1234");
            securityService.saveNewUser("ahmed","1234","1234");
            securityService.saveNewUser("mohammed","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("khaoula","USER");
            securityService.addRoleToUser("khaoula","ADMIN");
            securityService.addRoleToUser("mohammed","USER");
            securityService.addRoleToUser("ahmed","USER");


        };
    }
}
