package mx.unam.aragon.ico.is.peliculasapi.services;

import mx.unam.aragon.ico.is.peliculasapi.entities.Pelicula;
import mx.unam.aragon.ico.is.peliculasapi.repositories.PeliculaRepository;
import mx.unam.aragon.ico.is.peliculasapi.services.interfaces.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeliculaServiceimpl implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public Optional<Pelicula> buscarPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Iterable<Pelicula> listar() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula crear(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula actualizar(Long id, Pelicula pelicula) {
        Optional<Pelicula> peliculaActual = peliculaRepository.findById(id);

        if (peliculaActual.isPresent()) {
            Pelicula tmp = peliculaActual.get();
            tmp.setTitulo(pelicula.getTitulo());
            tmp.setDirector(pelicula.getDirector());
            tmp.setAnio(pelicula.getAnio());
            return peliculaRepository.save(tmp);
        }else {
            return null;
        }
    }

    @Override
    public Pelicula eliminar(Long id) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(id);
        if (pelicula.isPresent()) {
            peliculaRepository.deleteById(id);
            return pelicula.get();
        }
        return null;
    }

}
