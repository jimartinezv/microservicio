package co.edu.uniquindio.productos.exepciones;

public class ProductoNoEncontrado  extends RuntimeException {
    public ProductoNoEncontrado(String message) {
        super(message);
    }

}
