package edu.eci.cvds.stock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RepositorioProducto {
    private final Agente log;
    private final Agente advertencia;
}
