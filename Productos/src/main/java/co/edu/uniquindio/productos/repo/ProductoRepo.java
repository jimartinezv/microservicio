package co.edu.uniquindio.productos.repo;

import co.edu.uniquindio.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, String> {
}
