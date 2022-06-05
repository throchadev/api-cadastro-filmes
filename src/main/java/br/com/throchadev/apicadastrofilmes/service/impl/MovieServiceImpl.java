package br.com.throchadev.apicadastrofilmes.service.impl;

import br.com.throchadev.apicadastrofilmes.model.Movie;
import br.com.throchadev.apicadastrofilmes.repository.MovieRepository;
import br.com.throchadev.apicadastrofilmes.request.MovieRequest;
import br.com.throchadev.apicadastrofilmes.response.MovieResponse;
import br.com.throchadev.apicadastrofilmes.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieRepository movieRepository;

  public MovieResponse saveMovie(MovieRequest request){

    MovieResponse movieResponse = new MovieResponse();
    Movie movie = new Movie();
    movie.setMovie(String.valueOf(request.getPayload()));
    movieResponse.setPayload(movieRepository.save(movie));
    return movieResponse;
  }

  public MovieResponse searchMovie(Long id){

    MovieResponse movieResponse = new MovieResponse();
    var optionalMovie = getMovie(id);
    if(optionalMovie.isPresent()) {
      movieResponse.setPayload(optionalMovie);
    }
    return movieResponse;
  }

  public MovieResponse deleteMovie(Long id) {

    MovieResponse movieResponse = new MovieResponse();
    var optionalMovie = getMovie(id);
    if(optionalMovie.isPresent()) {
      movieRepository.delete(optionalMovie.get());
      movieResponse.setPayload("Movie Deleted!");
    }
    return movieResponse;
  }

  public MovieResponse updateMovie(Long id, MovieRequest request) {

    MovieResponse movieResponse = new MovieResponse();
    var optionalMovie = getMovie(id);

    if(optionalMovie.isPresent()) {
      Movie movie = optionalMovie.get();
      movie.setMovie(String.valueOf(request.getPayload()));
      movieResponse.setPayload(movieRepository.save(movie));
    }
    return movieResponse;
  }

  private Optional<Movie> getMovie(Long id) {
    Optional<Movie> movie = movieRepository.findById(id);
    return movie;
  }
}
