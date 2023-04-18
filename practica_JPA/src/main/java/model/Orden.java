package model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Orden")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name="Orden.all", query = "select e from Orden e")
})
public class Orden {
    @Id
    @SequenceGenerator(name="order_seq",sequenceName = "order_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    private Long OrdenId;

    private Date createDate = new Date();
    @Enumerated(EnumType.STRING)
    private EOrderStatus orderStatus;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> detailsOrderDetails;

    @ManyToOne (fetch = FetchType.LAZY)
    private Customer customer;

}
