package mx.unam.aragon.ico.is.peliculasapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name ="titulo_pelicula", nullable = false,  unique = true, length = 100)
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no debe exceder 100 caracteres")
    private String titulo;

    @Column(name = "director", nullable = false, length = 100)
    @NotBlank(message = "El director es obligatorio")
    private String director;

    @Column(name = "año_estreno", nullable = false)
    @Max(value = 2100, message = "El año debe ser menor o igual a 2030")
    @NotBlank(message = "El año es obligatorio")
    private Float anio;

    public Pelicula(){
    }

    public Pelicula(Long id, String titulo, String director, Float año) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Float getAnio() {
        return anio;
    }

    public void setAnio(Float anio) {
        this.anio = anio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return anio == pelicula.anio && Objects.equals(id, pelicula.id) && Objects.equals(titulo, pelicula.titulo) && Objects.equals(director, pelicula.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, director, anio);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", anio=" + anio +
                '}';
    }
}
