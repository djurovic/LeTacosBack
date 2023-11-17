package webshop.shopapi.form;

import lombok.Data;

import javax.swing.text.StyledEditorKit;
import java.math.BigDecimal;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;

/**
 * Created By Zhu Lin on 3/11/2018.
 */
@Data
public class ItemForm {
    //@Min(value = 1)
    private Integer quantity;
    //@NotEmpty
    private String productId;

    //meso
    private Integer mariniranaPiletina;
    private Integer mlevenaJunetina;
    private Integer rostiljKobasica;
    private Integer chickenNugets;
    private Integer cordonBleu;
    private Integer falafel;

    //extra dodaci
    private Boolean tostSir;
    private Boolean cedar;
    private Boolean zdenka;
    private Boolean gorgonzola;
    private Boolean slanina;
    private Boolean jalapeno;
    private Boolean hrskaviLuk;
    private Boolean guacamole;
    private Boolean gauda;
    private Boolean sampinjoni;

    //Besplatni Sos
    private String besplatniSos;

    //sosevi
    private Boolean kecap;
    private Boolean majonez;
    private Boolean sahara;
    private Boolean seville;
    private Boolean texasBbq;
    private Boolean ninjaBlend;
    private Boolean kari;
    private Boolean barbecue;
    private Boolean siracha;

    //Poseban zahtev
    private String posebanZahtev;

    private BigDecimal subTotal;
}
