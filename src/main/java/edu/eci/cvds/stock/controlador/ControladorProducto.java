package edu.eci.cvds.stock.controlador;

import edu.eci.cvds.stock.servicio.ServicioProducto;
import edu.eci.cvds.stock.modelo.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ControladorProducto {
    private final ServicioProducto servicioProducto;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto agregarProducto(@RequestBody Producto producto){
        return servicioProducto.agregarProducto(producto);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Producto modificarProducto(@RequestParam String nombre, @RequestParam int cantidad){
        return servicioProducto.modificarProducto(nombre,cantidad);
    }
    @DeleteMapping(value="/delete")
    public Producto eliminarProducto(@RequestBody Producto producto){
        return  servicioProducto.eliminarProducto(producto);
    }
}
