import dao.IDAO;
import dao.ImpIDAO;
import model.Customer;
import model.Item;
import model.Orden;
import model.OrderDetail;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Date now = new Date();
        //now.getTime();
        Customer a = new Customer(1L, "La calzada", "88712753", true, null );
        IDAO custom_dao = new ImpIDAO();
        //Orden o = new Orden(1L, now, null)

        custom_dao.create(a);

        /*Item i = new Item(1L, "ps5", 21.5, "videogames console", null);
        IDAO item_dao = new ImpIDAO();
        idao.create(i);**/
        System.out.println(custom_dao.findAll(Customer.class, "Customer.all"));
    }
}
