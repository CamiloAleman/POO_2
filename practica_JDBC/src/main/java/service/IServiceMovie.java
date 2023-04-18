package service;
import model.Movie;
import java.sql.SQLException;
import java.util.List;

public interface IServiceMovie {
    public List<Movie> getAll() throws SQLException;
    public void insertMovie(Movie movie) throws Exception;
    public void borrarMovie(Movie movie) throws Exception;
    public void updateMovie(Movie movie) throws Exception;
}
