package webshop.shopapi.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
public class OrderMain implements Serializable {
    private static final long serialVersionUID = -3819883511505235030L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "orderMain")
    private Set<ProductInOrder> products = new HashSet<>();

    @NotNull
    private String buyerEmail;

    @NotNull
    private String buyerName;

    @NotNull
    private String buyerSurname;

    @NotNull
    private String buyerPhone;

    @NotNull
    private String buyerUlica;

    @NotNull
    private String buyerBroj;

    @NotNull
    private String buyerInterfon;

    @NotNull
    private String buyerBrojStana;

    @NotNull
    private String buyerSprat;

    // Total Amount
    @NotNull
    private BigDecimal orderAmount;

    private String vreme;

    /**
     * default 0: new order.
     */
    @NotNull
    @ColumnDefault("0")
    private Integer orderStatus;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    public OrderMain(User buyer) {
        this.buyerEmail = buyer.getEmail();
        this.buyerName = buyer.getName();
        this.buyerSurname = buyer.getSurname();
        this.buyerPhone = buyer.getPhone();
        this.buyerUlica = buyer.getUlica();
        this.buyerBroj = buyer.getBroj();
        this.buyerInterfon = buyer.getInterfon();
        this.buyerBrojStana = buyer.getBrojStana();
        this.buyerSprat = buyer.getSprat();
        /*this.orderAmount = buyer.getCart().getProducts().stream().map(item -> item.getSubTotal().multiply(new BigDecimal(item.getCount())))
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal(0));*/
        this.orderAmount =  buyer.getCart().getProducts().stream().map(item -> item.getSubTotal()).reduce(BigDecimal::add).orElse(new BigDecimal(0));
        this.orderStatus = 0;

    }
}
