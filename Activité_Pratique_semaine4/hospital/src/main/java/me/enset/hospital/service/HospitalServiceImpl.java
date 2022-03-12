package me.enset.hospital.service;

import me.enset.hospital.entities.Consultation;
import me.enset.hospital.entities.Medecin;
import me.enset.hospital.entities.Patient;
import me.enset.hospital.entities.RendezVous;
import me.enset.hospital.repositories.ConsultationRepository;
import me.enset.hospital.repositories.MedecinRepository;
import me.enset.hospital.repositories.PatientRepository;
import me.enset.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
   private PatientRepository patientRepository;
   private MedecinRepository medecinRepository;
   private RendezVousRepository rendezVousRepository;
   private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository,
                               MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository,
                               ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        //générer une chaine de carac unique car elle prend la date du systéme
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
