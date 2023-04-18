package org.example;
import model.Libro;
import service.DataSource;
import service.IServiceLibro;
import service.ImpServiceLibro;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Libro>  libros  = new ArrayList<>();
        IServiceLibro service = new ImpServiceLibro();
        libros = service.getAll();
        //System.out.println("ANTES***************");
        //System.out.println(libros.toString());
        //System.out.println("DESPUES******************");
        //service.insertLibro(new Libro(2L,"WAR","WAR"));
       // libros = service.getAll();
       // System.out.println(libros.toString());

        //System.out.println("BORRAR LIBRO ****************");
        //service.borrarLibro(new Libro(1L,"Caperucita","Caperucita"));
        //libros = service.getAll();
        System.out.println(libros.toString());
    }
}