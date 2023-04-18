package service;
import model.Genre;
import java.sql.SQLException;
import java.util.List;

public interface IServiceGenre {
    public List<Genre> getAll() throws SQLException;
    public void insertGenre(Genre genre) throws Exception;
    public void borrarGenre(Genre genre) throws Exception;
    public void updateGenre (Genre genre) throws Exception;
}
