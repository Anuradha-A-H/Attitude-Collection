package Attitude_Collection.AttitudeCollectionOfficePannel.service;


import Attitude_Collection.AttitudeCollectionOfficePannel.emun.Status;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Products;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Subcategory;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.ProductRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.SubcategoryRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.AddProductRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.ProductsRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.ProductDtlResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.ProductdetailResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.util.ImageUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductsService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private SubcategoryRepository subcategoryRepo;

    @Value("${project.image}")
    private String path;

    public String addProduct(AddProductRequest product) throws IOException {
        Optional<Subcategory> subcategory = subcategoryRepo.findById(product.getSubcategoryId());
        if(subcategory.isEmpty())
            return "something went wrong";
        Products pro = Products.builder()
                .productName(product.getProductName())
                .productQuantity(product.getProductQuantity())
                .image(ImageUtil.compressImage(product.getImage().getBytes()))
                .price(product.getPrice())
                .description(product.getDescription())
                .subcategory(subcategory.get())
                .rating(0)
                .status(product.getProductQuantity() <= 0?Status.OUTOFSTOCK:Status.INSTOCK)
                .build();
        Subcategory sub = subcategory.get();
        List<Products> productsList = subcategory.get().getProductsList();
        productsList.add(pro);
        sub.setProductsList(productsList);
        subcategoryRepo.save(sub);
        return " Product added Successfully";
    }

    public ProductDtlResponse getProductById(String id)
    {
        Optional<Products> productdtl = productRepo.findById(id);
        if(productdtl.isEmpty())
            return null;
        Products product = productdtl.get();
         return ProductDtlResponse.builder()
                 .productName(product.getProductName())
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
            byte[] decompressedImage = ImageUtil.decompressImage(pro.getImage());
//            System.out.println(decompressedImage);
            productDtlResponses.add(ProductDtlResponse.builder()
                    .productName(pro.getProductName())
                    .subcategoryName(pro.getSubcategory().getSubcategoryName())
                    .productId(pro.getProductId())
                    .productQuantity(pro.getProductQuantity())
                    .image(Base64.encodeBase64String(decompressedImage))
                    .categoryName(pro.getSubcategory().getCategory().getCategoryName())
                    .status(pro.getStatus())
                    .rating(pro.getRating())
                    .price(pro.getPrice())
                    .description(pro.getDescription())
                    .build());
        }
        return productDtlResponses;
    }
    public List<ProductdetailResponse> getAllProducts(){
        List<Products> productsList = productRepo.findAll();
        List<ProductdetailResponse> productDtlResponses = new ArrayList<>();
        for(Products pro : productsList)
        {
//            System.out.println(Paths.get(pro.getImage()));
            byte[] decompressedImage = ImageUtil.decompressImage(pro.getImage());
            productDtlResponses.add(ProductdetailResponse.builder()
                    .productName(pro.getProductName())
                    .subcategoryName(pro.getSubcategory().getSubcategoryName())
                    .productId(pro.getProductId())
                    .productQuantity(pro.getProductQuantity())
                    .image(Base64.encodeBase64String(decompressedImage))
                    .categoryName(pro.getSubcategory().getCategory().getCategoryName())
                    .status(pro.getStatus())
                    .rating(pro.getRating())
                    .price(pro.getPrice())
                    .description(pro.getDescription())
                    .build());
        }
        return productDtlResponses;
    }


//    public String  uploadImage(String path, MultipartFile file) throws IOException {
//
//        // file name
//        String name = file.getOriginalFilename();
//        //full path
//        String randomId = UUID.randomUUID().toString();
//        String fillename1 = randomId.concat(name.substring(name.lastIndexOf(".")));
//        String fileePath = path+ File.separator+fillename1;
//        //create folder if not created
//        File f= new File(path);
//        if(!f.exists())
//        {
//            f.mkdir();
//        }
//        // file copy
//        Files.copy(file.getInputStream(), Paths.get(fileePath));
//        return fillename1;
//    }
}
