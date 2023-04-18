package dao;
import java.util.List;

public interface IDAO {
    <U> List<U> findAll(Class<U> Uclass, String nameQuery);
    <U> void create (U entity);
    <U> void delete (U entity);
    <U> void update (U entity);
}
