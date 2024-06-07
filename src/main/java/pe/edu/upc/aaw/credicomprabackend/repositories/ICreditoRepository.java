package pe.edu.upc.aaw.credicomprabackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.credicomprabackend.entities.Credito;
@Repository
public interface ICreditoRepository extends JpaRepository<Credito,Long> {
}
