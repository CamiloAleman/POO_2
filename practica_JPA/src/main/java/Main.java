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
        Date now = new Date();
        now.getTime();
        /*Customer a = new Customer(null, "La calzada", "88712753", true);
        IDAO custom_dao = new ImpIDAO();
        custom_dao.create(a);*/

        /*Item i = new Item(null, "ps5", 21.5F, "videogames console");
        IDAO item_dao = new ImpIDAO();
        item_dao.create(i);
        System.out.println(item_dao.findAll(Item.class, "Item.all"));*/

        /*OrderDetail od = new OrderDetail(null, 3, "15%",1L);
        IDAO odetail = new ImpIDAO();
        odetail.create(od);
        System.out.println(odetail.findAll(OrderDetail.class, "OrderDetail.all"));*/

        Orden o = new Orden(null, now, null, 1L, 1L);
        IDAO ordenDAO = new ImpIDAO();
        ordenDAO.create(o);
        System.out.println(ordenDAO.findAll(Orden.class, "Orden.all"));
    }
}