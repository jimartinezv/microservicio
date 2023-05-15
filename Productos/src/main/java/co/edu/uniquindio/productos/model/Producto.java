package co.edu.uniquindio.productos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Producto implements Serializable {
    @Id
    private String codigo;

    private String nombre;

    private String descripcion;

    private double precio;
}
