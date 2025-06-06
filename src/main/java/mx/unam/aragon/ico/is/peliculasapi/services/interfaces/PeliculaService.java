package mx.unam.aragon.ico.is.peliculasapi.services.interfaces;

import mx.unam.aragon.ico.is.peliculasapi.entities.Pelicula;

import java.util.Optional;

public interface PeliculaService {
    public abstract Optional<Pelicula> buscarPorId(Long id);
    public abstract Iterable<Pelicula> listar();
    public abstract Pelicula crear(Pelicula pelicula);
    public abstract Pelicula actualizar(Long id,Pelicula pelicula);
    public abstract Pelicula eliminar(Long id);
}
