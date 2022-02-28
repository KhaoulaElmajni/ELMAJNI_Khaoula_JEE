package ma.enset.jpaap.repositories;

import ma.enset.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {

    public List<Patient> findByMaladie(String malade);
    public List<Patient> findByMaladieAndIdLessThan(String malade);
    public Page<Patient> findByMaladie(String malade, Pageable pageable);
    public List<Patient> findByDAndDateCreBetweenAAndMaladieIsTrueAndNomIsLike (Date d1,Date d2,String nom);
    @Query("select p from Patient p where p.dateCre between :x and :y or p.nom like :z")
    public List<Patient> chercherPatient(@Param("x") Date d1,@Param("y")  Date d2,@Param("z")  String nom);



}
