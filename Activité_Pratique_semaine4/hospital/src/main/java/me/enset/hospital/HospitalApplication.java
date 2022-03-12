package me.enset.hospital;

import me.enset.hospital.entities.*;
import me.enset.hospital.repositories.ConsultationRepository;
import me.enset.hospital.repositories.MedecinRepository;
import me.enset.hospital.repositories.PatientRepository;
import me.enset.hospital.repositories.RendezVousRepository;
import me.enset.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository,
                            MedecinRepository medecinRepository){
        return args -> {
            //tous le code ici va s'exécuter au démarrage
            Stream.of("moahemmed","khaoula","ahmed")
                    .forEach(name ->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("khadija","badr","siham")
                    .forEach(name ->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"chirurgie");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohammed");

            Medecin medecin = medecinRepository.findByNom("khadija");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateCreation(new Date());
            rendezVous.setStatus(StatusRDV.CANCELED);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            RendezVous savedRDV = hospitalService.saveRendezVous(rendezVous);
            System.out.println(savedRDV.getId());

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapportConsultation("rapport...");
            hospitalService.saveConsultation(consultation);
        };
    }

}
