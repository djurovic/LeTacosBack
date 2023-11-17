package webshop.shopapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;*/
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class ProductInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrderMain orderMain;


    //@NotEmpty
    private String productId;


    //@NotEmpty
    private String productName;

    /*@NotNull
    private String productDescription;*/

    private String productIcon;

    //@NotNull
    private Integer categoryType;

    //@NotNull
    private BigDecimal productPrice;

    /*@Min(0)
    private Integer productStock;*/

    //@Min(1)
    private Integer count;

    //Dodaci
    //Meso za takose
    @Column(name = "mariniranaPiletina")
    private Integer mariniranaPiletina;

    @Column(name = "mlevenaJunetina")
    private Integer mlevenaJunetina;

    @Column(name = "rostiljKobasica")
    private Integer rostiljKobasica;

    @Column(name = "chickenNugets")
    private Integer chickenNugets;

    @Column(name = "cordonBleu")
    private Integer cordonBleu;

    @Column(name = "falafel")
    private Integer falafel;

    //Extra dodaci
    @Column(name = "tostSir")
    private Boolean tostSir;

    @Column(name = "cedar")
    private Boolean cedar;

    @Column(name = "zdenka")
    private Boolean zdenka;

    @Column(name = "gorgonzola")
    private Boolean gorgonzola;

    @Column(name = "slanina")
    private Boolean slanina;

    @Column(name = "jalapeno")
    private Boolean jalapeno;

    @Column(name = "hrskaviLuk")
    private Boolean hrskaviLuk;

    @Column(name = "guacamole")
    private Boolean guacamole;

    @Column(name = "gauda")
    private Boolean gauda;

    @Column(name= "sampinjoni")
    private Boolean sampinjoni;

    //Besplatni sos
    @Column(name = "besplatniSos")
    private String besplatniSos;

    //Sosevi
    @Column(name = "kecap")
    private Boolean kecap;

    @Column(name = "majonez")
    private Boolean majonez;

    @Column(name = "seville")
    private Boolean seville;

    @Column(name = "sahara")
    private Boolean sahara;

    @Column(name = "texasBbq")
    private Boolean texasBbq;

    @Column(name = "ninjaBlend")
    private Boolean ninjaBlend;

    @Column(name = "kari")
    private Boolean kari;

    @Column(name = "siracha")
    private Boolean siracha;

    @Column(name = "barbecue")
    private Boolean barbecue;

    //Poseban zahtev
    @Column(name = "posebanZahtev")
    private String posebanZahtev;


    @Column(name = "subTotal")
    private BigDecimal subTotal;


    public ProductInOrder(ProductInfo productInfo, Integer quantity,
                          Integer mariniranaPiletina, Integer mlevenaJunetina,Integer rostiljKobasica, Integer chickenNugets, Integer cordonBleu, Integer falafel,
            Boolean tostSir, Boolean cedar,Boolean gauda, Boolean zdenka, Boolean gorgonzola, Boolean slanina, Boolean jalapeno,Boolean sampinjoni, Boolean hrskaviLuk, Boolean guacamole, String besplatniSos,
            Boolean kecap, Boolean majonez, Boolean sahara, Boolean seville, Boolean texasBbq, Boolean ninjaBlend, Boolean kari, Boolean siracha, Boolean barbecue, String posebanZahtev,
            BigDecimal subTotal) {
        this.productId = productInfo.getProductId();
        this.productName = productInfo.getProductName();
        this.productIcon = productInfo.getProductIcon();
        this.categoryType = productInfo.getCategoryType();
        this.productPrice = productInfo.getProductPrice();
        this.count = quantity;
        this.mariniranaPiletina = mariniranaPiletina;
        this.mlevenaJunetina = mlevenaJunetina;
        this.rostiljKobasica = rostiljKobasica;
        this.chickenNugets = chickenNugets;
        this.cordonBleu = cordonBleu;
        this.falafel = falafel;
        this.tostSir = tostSir;
        this.cedar = cedar;
        this.zdenka = zdenka;
        this.gorgonzola = gorgonzola;
        this.slanina = slanina;
        this.jalapeno = jalapeno;
        this.hrskaviLuk = hrskaviLuk;
        this.guacamole = guacamole;
        this.besplatniSos = besplatniSos;
        this.kecap = kecap;
        this.majonez = majonez;
        this.sahara = sahara;
        this.seville = seville;
        this.texasBbq = texasBbq;
        this.ninjaBlend = ninjaBlend;
        this.kari = kari;
        this.siracha = siracha;
        this.barbecue = barbecue;
        this.gauda=gauda;
        this.sampinjoni=sampinjoni;
        this.posebanZahtev=posebanZahtev;
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "ProductInOrder{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productIcon='" + productIcon + '\'' +
                ", categoryType=" + categoryType +
                ", productPrice=" + productPrice +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductInOrder that = (ProductInOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productIcon, that.productIcon) &&
                Objects.equals(categoryType, that.categoryType) &&
                Objects.equals(productPrice, that.productPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, productId, productName, productIcon, categoryType, productPrice);
    }
}
