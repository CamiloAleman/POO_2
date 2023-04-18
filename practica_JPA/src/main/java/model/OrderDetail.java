package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@Table(name="OrderDetail")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name="OrderDetail.all", query = "select e from OrderDetail e")
})
public class OrderDetail {
    @Id
    @SequenceGenerator(name="orderDetail_seq",sequenceName = "orderDetail_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderDetail_seq")
    private Long Orderdetail_id;
    private int quantity;
    private String taxStatus;

    @ManyToOne (fetch = FetchType.LAZY)
    private Orden orden;
    @ManyToOne (fetch = FetchType.LAZY)
    private Item item;
}
