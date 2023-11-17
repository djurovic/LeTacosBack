package webshop.shopapi.controllers;


import webshop.shopapi.entity.Cart;
import webshop.shopapi.entity.ProductInOrder;
import webshop.shopapi.entity.User;
import webshop.shopapi.form.ItemForm;
import webshop.shopapi.repository.ProductInOrderRepository;
import webshop.shopapi.service.CartService;
import webshop.shopapi.service.ProductInOrderService;
import webshop.shopapi.service.ProductService;
import webshop.shopapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;


@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductInOrderService productInOrderService;
    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @PostMapping("")
    public ResponseEntity<Cart> mergeCart(@RequestBody Collection<ProductInOrder> productInOrders, Principal principal) {
        User user = userService.findOne(principal.getName());
        try {
            cartService.mergeLocalCart(productInOrders, user);
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Merge Cart Failed");
        }
        return ResponseEntity.ok(cartService.getCart(user));
    }

    @GetMapping("")
    public Cart getCart(Principal principal) {
        User user = userService.findOne(principal.getName());
        return cartService.getCart(user);
    }


    @PostMapping("/add")
    public boolean addToCart(@RequestBody ItemForm form, Principal principal) {
        var productInfo = productService.findOne(form.getProductId());
        try {
            mergeCart(Collections.singleton(new ProductInOrder(productInfo, form.getQuantity(),
                    form.getMariniranaPiletina(),form.getMlevenaJunetina(), form.getRostiljKobasica(),
                    form.getChickenNugets(),form.getCordonBleu(),form.getFalafel(),
                    form.getTostSir(),form.getCedar(),form.getZdenka(),form.getGauda(),form.getSampinjoni(),
                    form.getGorgonzola(),form.getSlanina(),form.getJalapeno(),
                    form.getHrskaviLuk(),form.getGuacamole(), form.getBesplatniSos(),
                    form.getKecap(),form.getMajonez(),form.getSahara(),
                    form.getSeville(),form.getTexasBbq(),form.getNinjaBlend(),
                    form.getKari(),form.getSiracha(),form.getBarbecue(),form.getPosebanZahtev(),
                    form.getSubTotal())), principal);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @PutMapping("/{itemId}")
    public ProductInOrder modifyItem(@PathVariable("itemId") String itemId, @RequestBody Integer quantity, Principal principal) {
        User user = userService.findOne(principal.getName());
         productInOrderService.update(itemId, quantity, user);
        return productInOrderService.findOne(itemId, user);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable("itemId") String itemId, Principal principal) {
        User user = userService.findOne(principal.getName());
         cartService.delete(itemId, user);
         // flush memory into DB
    }


    @PostMapping("/checkout")
    public ResponseEntity checkout(Principal principal) {
        User user = userService.findOne(principal.getName());// Email as username
        cartService.checkout(user);
        return ResponseEntity.ok(null);
    }


}
