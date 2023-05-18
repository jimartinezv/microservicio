package co.edu.uniquindio.productos.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@Builder

@AllArgsConstructor
public class Producto implements Serializable {
    @Id
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private double precio;
}
