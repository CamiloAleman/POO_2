package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="Item")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name="Item.all", query = "select e from Item e")
})
public class Item {
    @Id
    @SequenceGenerator(name="item_seq",sequenceName = "item_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    private Long Item_id;
    private String name;
    private float weight;
    private String description;

    @OneToMany (mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List <OrderDetail> detailsOrderDetails;
}
