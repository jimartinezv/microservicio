package co.edu.uniquindio.Users.repositorio;


import co.edu.uniquindio.Users.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactorRepositorio extends JpaRepository<Contacto,Integer> {
}
