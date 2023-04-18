package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(name="Customer.all", query = "select e from Customer e")
})
public class Customer {
    @Id
    @SequenceGenerator(name="customer_seq",sequenceName = "customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long id;
    private String deliveryAddress;
    private String contact;
    private boolean active;

    @OneToMany (mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orden> detailOrder;
}
