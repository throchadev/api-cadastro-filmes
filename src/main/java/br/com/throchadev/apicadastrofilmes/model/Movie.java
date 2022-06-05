package br.com.throchadev.apicadastrofilmes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "MOVIE")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String movie;

  @Column(nullable = false, updatable = false)
  @CreationTimestamp
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date created;
}
