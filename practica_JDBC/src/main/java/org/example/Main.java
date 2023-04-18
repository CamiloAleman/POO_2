package org.example;
import model.Genre;
import model.Movie;
import model.Rating;
import service.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Rating> ratings = new ArrayList<>();
        List<Movie> movies  = new ArrayList<>();
        List<Genre> genres = new ArrayList<>();
        IServiceMovie movservice = new ImpServiceMovie();
        IServiceRating ratservice = new ImpServiceRating();
        IServiceGenre genreservice = new ImpServiceGenre();
        movies = movservice.getAll();
        ratings = ratservice.getAll();
        genres = genreservice.getAll();
        Date RN = new Date();
        RN.getTime();
        RN.getTime();

        //INSERTAR PELICULA
        movservice.insertMovie(new Movie(203L,"Mario movie", "180 mins", RN, "8729472", 5612L, 1342L));
        System.out.println(movies.toString());

        //BORRAR PELICULA
        movservice.borrarMovie(new Movie(203L,"Mario movie", "180 mins", RN, "8729472", 5612L, 1342L));
        System.out.println(movies.toString());

        //ACTUALIZAR PELICULA
        movservice.updateMovie(new Movie (203L,"Mario movie", "2080 mins", RN , "8729472", 5612L, 1342L));
        System.out.println(movies.toString());

        //INSERTAR RATING
        ratservice.insertRating(new Rating(504L, "4 estrellas"));
        System.out.println(ratings.toString());

        //BORRAR RATING
        ratservice.borrarRating(new Rating(504L, "4 estrellas"));
        System.out.println(ratings.toString());

        //ACTUALIZAR RATING
        ratservice.updateRating(new Rating());
        System.out.println(ratings.toString());

        //INSERTAR GENERO
        genreservice.insertGenre(new Genre(33101L, "ficcion"));
        System.out.println(genres.toString());

        //BORRAR GENERO
        genreservice.borrarGenre(new Genre(33101L, "ficcion"));
        System.out.println(genres.toString());

        //ACTUALIZAR GENERO
        genreservice.updateGenre(new Genre(33101L, "comedia y romance"));
        System.out.println(genres.toString());

    }
}