package co.edu.uniquindio.productos.controller;

import co.edu.uniquindio.productos.dto.ProductoDTO;
import co.edu.uniquindio.productos.dto.ProductoDTOSave;
import co.edu.uniquindio.productos.model.Producto;
import co.edu.uniquindio.productos.servicio.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
@AllArgsConstructor
public class ProductoController {

    //private final LibroServicio libroServicio;

    private final ProductoServicio productoServicio;
    /**
    @PostMapping
    public ResponseEntity<Respuesta<Producto>> save(@RequestBody ProductoDTO productoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body( new Respuesta<>("Producto creado correctamente", productoServicio.save(productoDTO)) );
    }**/
    @PostMapping("/crear")
    public ResponseEntity<Respuesta<Producto>> save(@RequestBody ProductoDTO cliente){

        return ResponseEntity.status(HttpStatus.CREATED).body( new Respuesta<>("Producto creado correctamente", productoServicio.save(cliente)) );
    }

    @GetMapping
    public ResponseEntity<Respuesta<List<Producto>>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body( new Respuesta<>("", productoServicio.findAll()) );
    }

    @GetMapping("/exists/{idProducto}")
    public ResponseEntity<Respuesta<Boolean>> existsById(@PathVariable Integer idProducto){
        return ResponseEntity.status(HttpStatus.OK).body( new Respuesta<>("", productoServicio.existsById(idProducto)) );
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<Respuesta<Producto>> findById(@PathVariable Integer idProducto){
        return ResponseEntity.status(HttpStatus.OK).body( new Respuesta<>("", productoServicio.findById(idProducto)) );
    }



    @GetMapping("/ids")
    public ResponseEntity<Respuesta<List<Producto>>> findByIds(@RequestBody List<Integer> idProducto){
        return ResponseEntity.status(HttpStatus.OK).body( new Respuesta<>("", productoServicio.findAllByIds(idProducto)) );
    }


}
