package br.com.throchadev.apicadastrofilmes.repository;

import br.com.throchadev.apicadastrofilmes.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

}
