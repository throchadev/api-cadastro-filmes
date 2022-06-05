package br.com.throchadev.apicadastrofilmes.controller;

import br.com.throchadev.apicadastrofilmes.request.MovieRequest;
import br.com.throchadev.apicadastrofilmes.response.MovieResponse;
import br.com.throchadev.apicadastrofilmes.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @PostMapping
  public ResponseEntity<MovieResponse> saveMovie(@RequestBody MovieRequest request) {

    MovieResponse movieResponse;
    if (request.getPayload().toString().isEmpty()) {
      return new ResponseEntity(request, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    movieResponse = movieService.saveMovie(request);
    return new ResponseEntity(movieResponse, HttpStatus.CREATED);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<MovieResponse> searchMovie(@PathVariable Long id) {

    MovieResponse movieResponse;
    movieResponse = movieService.searchMovie(id);
    if (movieResponse.getPayload() == null) {
      return new ResponseEntity(movieResponse, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(movieResponse, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<MovieResponse> deleteMovie(@PathVariable Long id) {

    MovieResponse movieResponse;
    movieResponse = movieService.deleteMovie(id);
    if (movieResponse.getPayload() == null) {
      return new ResponseEntity(movieResponse, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(movieResponse, HttpStatus.OK);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @RequestBody MovieRequest request) {

    MovieResponse movieResponse;
    movieResponse = movieService.updateMovie(id, request);
    if (movieResponse.getPayload() == null) {
      return new ResponseEntity(movieResponse, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity(movieResponse, HttpStatus.OK);
  }
}
