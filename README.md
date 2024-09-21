# PARCIAL PRIMER CORTE - SOLID, PATRONES, TDD, SPRING

## PRE-RREQUISITOS
- Java JDK Runtime Environment: 17.x.x
- Apache Maven: 3.9.x
- JUnit: 5.x.x

## NECESIDAD DEL CLIENTE
El cliente necesita un sistema de monitoreo de stock de productos, el cual le permita agregar productos nuevos y actualizar la cantidad de productos disponibles. Adicionalmente cada vez que un producto sea actualizado es necesario que se notifique a los dos agentes que serán implementados; Para los agentes es necesario tener en cuenta las siguientes características, el primero deberá escribir en el stdout las unidades disponibles y el segundo agente deberá escribir en el stdout si hay menos de 5 unidades disponibles lo cual generará una alerta. Estas funcionalidades deben ser expuestas en un servicio REST.
## REQUERIMIENTO
### FUNCIONALES
1. **Añadir un producto:** los productos deben tener nombre, precio, cantidad en stock y categoría.
2. **Modificar stock:** Se debe actualizar la cantidad de producto disponible y adicionalmente se debe notificar a los interesados.
    - Notificar el cambio de stock: Los agentes se deben ejecutar según los requerimientos de cada uno, cuando el stock de cualquier producto se vea afectado.
### AGENTES:
##### AGENTE LOG
Este agente debe escribir en stdout cada vez que se modifica el stock de un producto.
Ejemplo:
```bash
 Prodcto: xbox one s -> 10 unidades disponibles
 ```
##### AGENTE ADVERTENCIA
Este agente debe escribir en stdout cada vez que el stock de un producto es menor a 5.
Ejemplo:
```bash
 ALERTA!!! El stock del Prodcto: xbox one s es muy bajo, solo quedan 4 unidades.
 ```
## DESCRIPCIÓN DEL PROYECTO
Se debe crear un repositorio en GitHub el cual debe tener un proyecto maven que funcione con spring-boot, este proyecto deberá darle solución a los requerimientos del cliente y seguir los principios SOLID. Se debe implementar por lo menos un patrón de diseño, usar la inyección de dependencias para instaciar objetos y es necesario que los endpoint REST utilicen los métodos (GET, POST, PATCH, PUT, DELETE), dependiendo de la operación que sea requerida. El proyecto debe tener pruebas unitarias y jacoco como plugin de cobertura y esta  cobertura deberá ser  superior al 80%.

#####  ES IMPORTANTE RECORDAR QUE:

1. El almacenamiento puede ser en estructuras en memoria como Listas, Mapas, etc
2. El proyecto debe funcionar localmente en el puerto 8080.
3. Se debe subir el link del proyecto en el espacio de campus virtual

## Documentación:

Se uso la herramienta spring initializr y se añadieron las siguientes dependencias Spring Web, Lombok
El patron escogido fue Observer debido a que es el mas idoneo para implementar, ya que el repositorio de productos los tendra como atributos Agente, para que cada vez
que se modifique un producto se puedan enterar y actuar segun sea el caso.

# Diagrama de clases:

![imagen](https://github.com/Daniel-Aldana10/ParcialCVDS/images/diagrama_clases.png)

# Pruebas:

Se decidio solo probar la clase del repositorio de los productos que vendria siendo donde se van a guardar los productos en stock, debido a que aqui se implementa toda la
logica del negocio, cuando se puede añadir un producto, cuando no, es el que le informa a los agentes las modificaciones que hubieron y tiene todas las funciones que son necesarias.

![imagen](https://github.com/Daniel-Aldana10/ParcialCVDS/images/pruebas.png)


