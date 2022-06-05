package br.com.throchadev.apicadastrofilmes.service.interfaces;

import br.com.throchadev.apicadastrofilmes.request.MovieRequest;
import br.com.throchadev.apicadastrofilmes.response.MovieResponse;

public interface MovieService {

  MovieResponse saveMovie(MovieRequest request);

  MovieResponse searchMovie(Long id);

  MovieResponse deleteMovie(Long id);

  MovieResponse updateMovie(Long id, MovieRequest request);
}
