package webshop.shopapi.controllers;


import webshop.shopapi.entity.ProductCategory;
import webshop.shopapi.entity.ProductInfo;
import webshop.shopapi.service.CategoryService;
import webshop.shopapi.service.ProductService;
import webshop.shopapi.vo.response.CategoryPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    /**
     * Show products in category
     *
     * @param categoryType
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/category/{type}")
    public CategoryPage showOne(@PathVariable("type") Integer categoryType,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "99") Integer size) {

        ProductCategory cat = categoryService.findByCategoryType(categoryType);
        PageRequest request = PageRequest.of(page - 1, size);
        Page<ProductInfo> productInCategory = productService.findAllInCategory(categoryType, request);
        var tmp = new CategoryPage("", productInCategory);
        tmp.setCategory(cat.getCategoryName());
        return tmp;
    }
}
