package service;

import model.Libro;

import java.sql.SQLException;
import java.util.List;

public interface IServiceLibro {
    public List<Libro> getAll() throws SQLException;
    public void insertLibro(Libro libro) throws Exception;
    public void borrarLibro(Libro libro) throws Exception;
}
