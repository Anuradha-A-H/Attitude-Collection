package Attitude_Collection.AttitudeCollectionOfficePannel.service;


import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Status;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Products;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Subcategory;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.ProductRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.SubcategoryRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.ProductsRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.ProductDtlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private SubcategoryRepository subcategoryRepo;

    public String addProduct(ProductsRequest product){
        Optional<Subcategory> subcategory = subcategoryRepo.findById(product.getSubcategoryId());
        if(subcategory.isEmpty())
            return "something went wrong";
        Products pro = Products.builder()
                .productName(product.getProductName())
                .productQuantity(product.getProductQuantity())
                .image(product.getImage())
                .price(product.getPrice())
                .description(product.getDescription())
                .rating(product.getRating())
                .status(product.getProductQuantity() <= 0?Status.OUTOFSTOCK:Status.INSTOCK)
                .build();
        Subcategory sub = subcategory.get();
        List<Products> productsList = subcategory.get().getProductsList();
        productsList.add(pro);
        sub.setProductsList(productsList);
        subcategoryRepo.save(sub);
        productRepo.save(pro);
        return " Product added Successfully";
    }

    public ProductDtlResponse getProductById(String id)
    {
        Optional<Products> productdtl = productRepo.findById(id);
        if(productdtl.isEmpty())
            return null;
        Products product = productdtl.get();
         return ProductDtlResponse.builder()
                .subcategoryName(product.getSubcategory().getSubcategoryName())
                .productId(product.getProductId())
                .productQuantity(product.getProductQuantity())
                .categoryName(product.getSubcategory().getCategory().getCategoryName())
                .status(product.getStatus())
                .rating(product.getRating())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();

    }
    public String deleteProductBuId(String id)
    {
        Optional<Products> pro = productRepo.findById(id);
        if(pro.isEmpty())
            return "Invalid Id";
        Products product = pro.get();
        Subcategory subcategory = product.getSubcategory();
        List<Products> productsList = subcategory.getProductsList();
        productsList.remove(product);
        subcategory.setProductsList(productsList);
        subcategoryRepo.save(subcategory);
        productRepo.deleteById(id);
        return "Deleted Successfully";
    }
    public List<ProductDtlResponse>  allProducts(){
        List<Products> productsList = productRepo.findAll();
        List<ProductDtlResponse> productDtlResponses = new ArrayList<>();
        for(Products pro : productsList)
        {
            productDtlResponses.add(ProductDtlResponse.builder()
                    .subcategoryName(pro.getSubcategory().getSubcategoryName())
                    .productId(pro.getProductId())
                    .productQuantity(pro.getProductQuantity())
                    .categoryName(pro.getSubcategory().getCategory().getCategoryName())
                    .status(pro.getStatus())
                    .rating(pro.getRating())
                    .price(pro.getPrice())
                    .description(pro.getDescription())
                    .build());
        }
        return productDtlResponses;
    }
}
