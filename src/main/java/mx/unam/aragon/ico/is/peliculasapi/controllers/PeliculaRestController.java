package mx.unam.aragon.ico.is.peliculasapi.controllers;


import mx.unam.aragon.ico.is.peliculasapi.entities.Pelicula;
import mx.unam.aragon.ico.is.peliculasapi.services.interfaces.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/api/v1/peliculas")

public class PeliculaRestController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Pelicula>> getPelicula() {

        return new ResponseEntity<>(peliculaService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getpeliculaPorId(@PathVariable Long id) {

        Optional<Pelicula> tmp = peliculaService.buscarPorId(id);
        if (tmp.isPresent()) {
            return new ResponseEntity<>(tmp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        return new ResponseEntity<>(peliculaService.crear(pelicula), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> noExiste() {
        return new ResponseEntity<>("End Point no soportado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pelicula> actualizaParcial(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        Pelicula tmp = peliculaService.buscarPorId(id).orElse(null);
        if (tmp != null) {
            if (pelicula.getTitulo() != null) tmp.setTitulo(pelicula.getTitulo());
            if (pelicula.getDirector() != null) tmp.setDirector(pelicula.getDirector());
            if (pelicula.getAnio() != null) tmp.setAnio(pelicula.getAnio());
            return new ResponseEntity<>(peliculaService.actualizar(id, tmp), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> editar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        Optional tmp = peliculaService.buscarPorId(id);

        if (tmp.isPresent()) {
            return new ResponseEntity<>(peliculaService.actualizar(id, pelicula), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pelicula> eliminar(@PathVariable Long id) {
        Pelicula tmp =peliculaService.eliminar(id);
        if (tmp != null){
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
