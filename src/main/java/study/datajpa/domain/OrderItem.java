package study.datajpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import study.datajpa.domain.item.Item;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    private int orderPrice; //주문 가격
    private Long count; //주문 수량
}
