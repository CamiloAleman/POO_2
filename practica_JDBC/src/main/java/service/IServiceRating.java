package service;
import model.Rating;
import java.sql.SQLException;
import java.util.List;

public interface IServiceRating {
    public List<Rating> getAll() throws SQLException;
    public void insertRating(Rating rating) throws Exception;
    public void borrarRating(Rating rating) throws Exception;
    public void updateRating(Rating rating) throws Exception;
}
