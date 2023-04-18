package service;
import model.Genre;
import model.Rating;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpServiceGenre implements IServiceGenre {
    @Override
    public List<Genre> getAll() throws SQLException {
        Connection con = null;
        String genreSQL = "select * from genre";
        List<Genre> genres = new ArrayList<>();
        try {
            con = DataSource.getInstance().openConnection();
            PreparedStatement ps = con.prepareStatement(genreSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setGenre(rs.getString("genre"));
                genre.setGenre_id(rs.getLong("genre_id"));
                genres.add(genre);
            }
            rs.close();
            ps.close();
            return genres;
        }
        finally {
            DataSource.getInstance().closeConnection(con);
        }
    }

    @Override
    public void insertGenre(Genre genre) throws Exception{
        Connection con = DataSource.getInstance().openConnection();
        con.setAutoCommit(false);
        final String genreSQL = "INSERT INTO GENRE (GENRE_ID, GENRE) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(genreSQL);
        ps.setLong(1,genre.getGenre_id());
        ps.setString(2,genre.getGenre());
        ps.execute();
        con.commit();
        ps.close();
        con.close();
    }

    @Override
    public void borrarGenre(Genre genre) throws Exception {
        Connection con  = DataSource.getInstance().openConnection();
        con.setAutoCommit(false);
        String genreSQL = "DELETE FROM GENRE WHERE GENRE_ID=?";
        PreparedStatement ps = con.prepareStatement(genreSQL);
        ps.setLong(1,genre.getGenre_id());
        ps.execute();
        con.commit();
        ps.close();
        con.close();
    }

    public void updateGenre (Genre genre) throws Exception {
        Connection con = DataSource.getInstance().openConnection();
        con.setAutoCommit(false);
        String genreSQL = "UPDATE GENRE SET GENRE = ? WHERE GENRE_ID = ?";
        PreparedStatement ps = con.prepareStatement(genreSQL);
        ps.setString(1, genre.getGenre());
        ps.setLong(2, genre.getGenre_id());
        ps.execute();
        con.commit();
        ps.close();
        con.close();
    }
}
