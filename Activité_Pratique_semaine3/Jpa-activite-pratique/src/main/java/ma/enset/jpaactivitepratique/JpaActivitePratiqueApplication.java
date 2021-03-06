package ma.enset.jpaactivitepratique;

import ma.enset.jpaactivitepratique.entities.Patient;
import ma.enset.jpaactivitepratique.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaActivitePratiqueApplication implements CommandLineRunner {


    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaActivitePratiqueApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i =0;i<100;i++){
            patientRepository.save(new Patient(null,"khaoula",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));
        }

        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("Total elements = "+patients.getTotalElements());//total des elts de la table
        System.out.println("Total pages = "+patients.getTotalPages());//le nbr total des pages
        System.out.println("Numero de page = "+patients.getNumber());//le numero de page actuelle
        List<Patient>content = patients.getContent();
        List<Patient> patientList = patientRepository.findByMalade(true);
        List<Patient> patients1 = patientRepository.chercherPatients("%h%",88);

        Page<Patient> byMalade = patientRepository.findByMalade(false,PageRequest.of(0,10));
        patients1.forEach(p->{
            System.out.println("______________________________________________________");
            System.out.println("id: "+p.getId()+" nom : "+p.getNom()+" malade : "
                    +p.isMalade()+" score: "+p.getScore());
        });
        System.out.println("*******************************");
        Patient patient = patientRepository.findById(1L).orElse(null);

        if (patient!= null){
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(1928);
        patientRepository.save(patient);
        //patientRepository.deleteById(1L);
    }
}
