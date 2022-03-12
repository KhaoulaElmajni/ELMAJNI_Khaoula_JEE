package me.enset.hospital.service;

import me.enset.hospital.entities.Consultation;
import me.enset.hospital.entities.Medecin;
import me.enset.hospital.entities.Patient;
import me.enset.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
