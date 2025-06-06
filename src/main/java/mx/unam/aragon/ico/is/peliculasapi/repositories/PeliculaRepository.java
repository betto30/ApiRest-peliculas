package mx.unam.aragon.ico.is.peliculasapi.repositories;

import mx.unam.aragon.ico.is.peliculasapi.entities.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {

}
