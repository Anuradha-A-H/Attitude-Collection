package Attitude_Collection.AttitudeCollectionOfficePannel.controller;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Products;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.ProductDtlResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.ProductlistResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.CategoryService;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.ProductsService;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductsService productsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubcategoryService subcategoryService;


    @GetMapping("/")
    public String allProducts(Model m){
        List<ProductDtlResponse> productsList = productsService.allProducts();
        m.addAttribute("pro",productsList);
        return "products";
    }

    @GetMapping("loadproducts")
    public String loadProducts(Model m){
        ProductlistResponse response = ProductlistResponse.builder()
                .categoryList(categoryService.allCategory())
                .subcategoryList(subcategoryService.subcategoryList())
                .build();
        m.addAttribute("lists",response);
        return "addproducts";
    }
}
