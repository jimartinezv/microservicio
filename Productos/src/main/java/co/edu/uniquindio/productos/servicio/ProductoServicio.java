package co.edu.uniquindio.productos.servicio;

import co.edu.uniquindio.productos.dto.ProductoDTO;
import co.edu.uniquindio.productos.dto.ProductoDTOSave;
import co.edu.uniquindio.productos.exepciones.ProductoNoEncontrado;
import co.edu.uniquindio.productos.model.Producto;
import co.edu.uniquindio.productos.repo.ProductoRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProductoServicio {


    private final ProductoRepo productoRepo;
    private final Environment environment;

    public Producto save(ProductoDTO producto){

        Optional<Producto> guardado = productoRepo.findById(producto.codigo());


        if(guardado.isPresent()){
            throw new RuntimeException("El Producto con el id "+producto.codigo()+" ya existe");
        }

        return productoRepo.save( convertir(producto) );
    }

    public Producto findById(Integer producto){
        return productoRepo.findById(producto).orElseThrow(()-> new ProductoNoEncontrado("El producto no existe"));

    }

    //public boolean existsById(String id){
      //  return productoRepo.existsById(id);
    //}
    public boolean existsById(Integer id){
        log.info("Puerto del proceso que responde: {}", environment.getProperty("local.server.port"));
        return productoRepo.existsById(id);
    }

    public List<Producto> findAll(){
        return productoRepo.findAll();
    }

    public List<Producto> findAllByIds(List<Integer> id){
        return productoRepo.findAllById(id);
    }

    public Producto update(ProductoDTO producto){
        return productoRepo.save( convertir(producto) );
    }

    private Producto convertir(ProductoDTO producto){
        /**
        List<Autor> autores = autorRepo.findAllById( libro.idAutores() );

        if(autores.size()!=libro.idAutores().size()){

            List<Long> idsExistentes = autores.stream().map(Autor::getId).toList();

            String noEncontrados = libro.idAutores()
                    .stream()
                    .filter(id -> !idsExistentes.contains(id))
                    .map(Object::toString)
                    .collect(Collectors.joining(","));

            throw new AutorNoEncontradoException("Los autores "+noEncontrados+" no existen");

        }**/

        Producto nuevo = Producto.builder()
                .codigo(producto.codigo())
                .nombre(producto.nombre())
                .descripcion(producto.descripcion())
                .precio(producto.precio())
                .build();

        System.out.println(nuevo.getCodigo()+"codigo");

        return nuevo;
    }
}
