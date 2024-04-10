package Attitude_Collection.AttitudeCollectionOfficePannel.controller;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Category;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Products;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.AddProductRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.ProductDtlResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.ProductdetailResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.ProductlistResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.CategoryService;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.ProductsService;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
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
        List<Category> categoryList = categoryService.allCategory();
        m.addAttribute("lists",categoryList);

        return "addproducts";
    }

    @PostMapping("/addproduct")
    public String addProduct(AddProductRequest request) throws IOException {
        System.out.println(request.getProductName()+" "+request.getProductQuantity()+" "+request.getDescription());
        String str = productsService.addProduct(request);
        return "redirect:/products/";
    }

    @GetMapping("/allProducts")
    public  ResponseEntity<List<ProductdetailResponse>> getAllProducts()
        {
            List<ProductdetailResponse> products =  productsService.getAllProducts();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(products);
        }
}
