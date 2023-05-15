package co.edu.uniquindio.productos.exepciones;

import co.edu.uniquindio.productos.controller.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ManejoDeExcepciones {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Respuesta<String>> capturarException(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( new Respuesta<>(e.getMessage()) );
    }

    @ExceptionHandler(ProductoNoEncontrado.class)
    public ResponseEntity<Respuesta<String>> capturarClienteNoEncontradoException(ProductoNoEncontrado e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new Respuesta<>(e.getMessage()) );
    }
}
