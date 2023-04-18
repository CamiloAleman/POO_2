package service;

import model.Genre;
import model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpServiceMovie implements IServiceMovie{
    @Override
    public List<Movie> getAll() throws SQLException {
        Connection con = null;
        String movieSQL = "select * from movie";
        List<Movie> movies = new ArrayList<>();
        try {
            con = DataSource.getInstance().openConnection();
            PreparedStatement ps = con.prepareStatement(movieSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setRating_id(rs.getLong("rating_id"));
                movie.setGenre_id(rs.getLong("genre_id"));
                movie.setImbd_id(rs.getString("imbd_id"));
                movie.setRelease_date(rs.getDate("release_date"));
                movie.setLength(rs.getString("length"));
                movie.setMovie_title(rs.getString("movie_title"));
                movie.setMovie_id(rs.getLong("movie_id"));
                movies.add(movie);
            }
            rs.close();
            ps.close();
            return movies;
        }
        finally {
            DataSource.getInstance().closeConnection(con);
        }
    }

    @Override
    public void insertMovie(Movie movie) throws Exception{
            Connection con = DataSource.getInstance().openConnection();
            con.setAutoCommit(false);
            final String movieSQL = "INSERT INTO MOVIE (MOVIE_ID,MOVIE_TITLE,LENGTH,RELEASE_DATE,IMBD_ID,GENRE_ID,RATING_ID) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(movieSQL);
            ps.setLong(1,movie.getMovie_id());
            ps.setString(2,movie.getMovie_title());
            ps.setString(3,movie.getLength());
            ps.setDate(4, new Date (movie.getRelease_date().getTime()));
            ps.setString(5, movie.getImbd_id());
            ps.setLong(6,movie.getGenre_id());
            ps.setLong(7,movie.getRating_id());
            ps.execute();
            con.commit();
            ps.close();
            con.close();
    }

    @Override
    public void borrarMovie(Movie movie) throws Exception {
          Connection con  = DataSource.getInstance().openConnection();
          con.setAutoCommit(false);
          String movieSQL = "DELETE FROM MOVIE WHERE MOVIE_ID=?";
          PreparedStatement ps = con.prepareStatement(movieSQL);
          ps.setLong(1,movie.getMovie_id());
          ps.execute();
          con.commit();
          ps.close();
          con.close();
    }

    public void updateMovie (Movie movie) throws Exception {
        Connection con = DataSource.getInstance().openConnection();
        con.setAutoCommit(false);
        String movieSQL = "UPDATE MOVIE SET MOVIE_TITLE = ?, LENGTH = ?, RELEASE_DATE = ?, IMBD_ID = ? WHERE MOVIE_ID = ?";
        PreparedStatement ps = con.prepareStatement(movieSQL);

        ps.setString(1,movie.getMovie_title());
        ps.setString(2,movie.getLength());
        ps.setDate(3, new Date (movie.getRelease_date().getTime()));
        ps.setString(4, movie.getImbd_id());
        ps.setLong(5,movie.getMovie_id());

        ps.execute();
        con.commit();
        ps.close();
        con.close();
    }
}
