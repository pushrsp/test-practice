package sample.firsttest.spring.domain.orderproduct;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.firsttest.spring.domain.BaseEntity;
import sample.firsttest.spring.domain.order.Order;
import sample.firsttest.spring.domain.product.Product;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
