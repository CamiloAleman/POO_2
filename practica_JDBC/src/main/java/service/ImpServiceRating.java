package service;
import model.Genre;
import model.Rating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpServiceRating implements IServiceRating{
    @Override
    public List<Rating> getAll() throws SQLException {
        Connection con = null;
        String ratingSQL = "select * from rating";
        List<Rating> ratings = new ArrayList<>();
        try {
            con = DataSource.getInstance().openConnection();
            PreparedStatement ps = con.prepareStatement(ratingSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rating rating = new Rating();
                rating.setRating(rs.getString("rating"));
                rating.setRating_id(rs.getLong("rating_id"));
                ratings.add(rating);
            }
            rs.close();
            ps.close();
            return ratings;
        }
        finally {
            DataSource.getInstance().closeConnection(con);
        }
    }

    @Override
    public void insertRating(Rating rating) throws Exception{
        Connection con = DataSource.getInstance().openConnection();
        con.setAutoCommit(false);
        final String ratingSQL = "INSERT INTO RATING (RATING_ID, RATING) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(ratingSQL);
        ps.setLong(1,rating.getRating_id());
        ps.setString(2,rating.getRating());
        ps.execute();
        con.commit();
        ps.close();
        con.close();
    }

    @Override
    public void borrarRating(Rating rating) throws Exception {
        Connection con  = DataSource.getInstance().openConnection();
        con.setAutoCommit(false);
        String ratingSQL = "DELETE FROM RATING WHERE RATING_ID=?";
        PreparedStatement ps = con.prepareStatement(ratingSQL);
        ps.setLong(1,rating.getRating_id());
        ps.execute();
        con.commit();
        ps.close();
        con.close();
    }

    public void updateRating (Rating rating) throws Exception {
        Connection con = DataSource.getInstance().openConnection();
        con.setAutoCommit(false);
        String ratingSQL = "UPDATE GENRE SET RATING = ? WHERE RATING_ID = ?";
        PreparedStatement ps = con.prepareStatement(ratingSQL);
        ps.setString(1, rating.getRating());
        ps.setLong(2, rating.getRating_id());
        ps.execute();
        con.commit();
        ps.close();
        con.close();
    }
}
