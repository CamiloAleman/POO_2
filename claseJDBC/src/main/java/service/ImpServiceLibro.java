package service;
import model.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpServiceLibro implements IServiceLibro{
    @Override
    public List<Libro> getAll() throws SQLException {
        Connection con = null;
        String libroSQL = "select * from Libro";
        List<Libro> libros = new ArrayList<>();
        try {
            con = DataSource.getInstance().openConnection();
            PreparedStatement ps = con.prepareStatement(libroSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setDescripcion(rs.getString("descripcion"));
                libro.setNombre(rs.getString("nombre"));
                libro.setId(rs.getLong("id"));
                libros.add(libro);
            }
            rs.close();
            ps.close();
            return libros;
        }
        finally {
            DataSource.getInstance().closeConnection(con);
        }
    }

    @Override
    public void insertLibro(Libro libro) throws Exception{
            Connection con = DataSource.getInstance().openConnection();
            con.setAutoCommit(false);
            final String libroSQL = "INSERT INTO LIBRO (ID,DESCRIPCION,NOMBRE) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(libroSQL);
            ps.setLong(1,libro.getId());
            ps.setString(2,libro.getDescripcion());
            ps.setString(3,libro.getNombre());
            ps.execute();
            con.commit();
            ps.close();
            con.close();
    }

    @Override
    public void borrarLibro(Libro libro) throws Exception {
          Connection con  = DataSource.getInstance().openConnection();
          con.setAutoCommit(false);
          String libroSQL = "DELETE FROM LIBRO WHERE ID=?";
          PreparedStatement ps = con.prepareStatement(libroSQL);
          ps.setLong(1,libro.getId());
          ps.execute();
          con.commit();
          ps.close();
          con.close();
    }
}
