package co.edu.uniquindio.users.repositorio;

import co.edu.uniquindio.users.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactorRepositorio extends JpaRepository<Contacto,Integer> {
}
