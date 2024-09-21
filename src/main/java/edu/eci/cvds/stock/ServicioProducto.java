package edu.eci.cvds.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ServicioProducto {
    private final RepositorioProducto repositorioProducto;

    public Producto agregarProducto( Producto producto){
        return repositorioProducto.agregarProducto(producto);
    }
    public Producto modificarProducto(String nombre, int cantidad){
        return repositorioProducto.modificarProducto(nombre,cantidad);
    }

    public Producto eliminarProducto(Producto producto){
        return  repositorioProducto.eliminarProducto(producto);
    }


}
