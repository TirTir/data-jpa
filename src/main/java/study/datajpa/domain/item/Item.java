package study.datajpa.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import study.datajpa.domain.Category;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Getter @Setter
public abstract class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private String id;
    private String name;
    private int price;
    private int stockQuantity;
    private Long<Category> category;
}
