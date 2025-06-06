package mx.unam.aragon.ico.is.peliculasapi;

import mx.unam.aragon.ico.is.peliculasapi.entities.Pelicula;
import mx.unam.aragon.ico.is.peliculasapi.repositories.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PeliculasapiApplicationTests {
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Test
	void contextLoads() {
	}

	/*@Test
	void insertarPelicula(){
		Pelicula pelicula1 = new Pelicula(null,"Batman el caballero de la noche", "Christopher Nola", 2008f);
		peliculaRepository.save(pelicula1);
		Pelicula pelicula3 = new Pelicula(null,"Isla de perros", "Wes Anderson", 2019f);
		peliculaRepository.save(pelicula3);
	}*/

}
