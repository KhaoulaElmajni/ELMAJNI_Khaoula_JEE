package ma.enset.jpaap;

import ma.enset.jpaap.entities.Patient;
import ma.enset.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i =0 ;i<100; i++){
            patientRepository.save(
                    new Patient(null,"hassan",new Date(),"sida")
            );
        }
        patientRepository.save(new Patient(null,"hassan",new Date(),"sida"));
        patientRepository.save(new Patient(null,"khaoula",new Date(),"sida"));
        patientRepository.save(new Patient(null,"khadija",new Date(),"sida"));
        patientRepository.save(new Patient(null,"amine",new Date(),"sida"));

        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("total page"+patients.getTotalPages());
        System.out.println("total page"+patients.getTotalElements());
        System.out.println("total page"+patients.getNumber());
List<Patient> content = patientRepository.findAll();

        content.forEach(p->{
            System.out.println("====================================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateCre());
        });
        System.out.println("");
        Patient patient = patientRepository.findById(new Long(1L)).get();

        Patient patient2 = patientRepository.findById(new Long(1L)).orElse(null);
        Patient patient3 = patientRepository.findById(new Long(1L)).orElseThrow(()->new RuntimeException("patient n'este pas"));

        if (patient != null){
            System.out.println(patient.getNom());
        }
        patient.setMaladie("grippe");
        patientRepository.save(patient);
        patientRepository.deleteById(1L);
    }
}
