package Attitude_Collection.AttitudeCollectionOfficePannel.service;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Category;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Subcategory;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.CategoryRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.SubcategoryRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.SubcategoryRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.SubcategoryResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.SubcategorylstResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    public String addSubcategory(SubcategoryRequest category)
    {
        Optional<Category> categoryDetails = categoryRepo.findById(category.getCategoryId());
        if(categoryDetails.isEmpty())
            return "Invalid categoryId";
        Subcategory subcategory = Subcategory.builder()
                .subcategoryName(category.getSubcategoryName())
                .category(categoryDetails.get())
                .build();
        Subcategory cat = subcategoryRepo.save(subcategory);

        return "Subcategory Added Successfully";
    }

    public SubcategoryResponse getSubcategoryById(Integer id)
    {

        Optional<Subcategory> sub= subcategoryRepo.findById(id);
        if( sub.isEmpty())
            return null;
        Subcategory subcategory = sub.get();
        return  SubcategoryResponse.builder()
                .subcategoryId(subcategory.getId())
                .subcategoryName(subcategory.getSubcategoryName())
                .categoryId(subcategory.getCategory().getId())
                .build();

    }

    public String deleteCategory(Integer id)
    {
        Optional<Subcategory> category = subcategoryRepo.findById(id);
        if(category.isEmpty())
            return "Invalid Id Entered";
        Subcategory subcategory = category.get();
        Category categoryDtl = subcategory.getCategory();


        List<Subcategory> subcategoryList= categoryDtl.getSubcategoryList();
        if(subcategoryList.contains(subcategory))
            subcategoryList.remove(subcategory);
        categoryDtl.setSubcategoryList(subcategoryList);


        Category category1 = Category.builder()
                        .categoryName(categoryDtl.getCategoryName())
                                .subcategoryList(categoryDtl.getSubcategoryList())
                                        .id(categoryDtl.getId())
                                                .build();


        categoryRepo.save(category1);
        subcategoryRepo.deleteById(id);
        return "Category Deleted Successfully";
    }

    public List<SubcategorylstResponse> allSubcategory()
    {
        List<SubcategorylstResponse> response = new ArrayList<>();
        List<Subcategory> categoryList = subcategoryRepo.findAll();
        for(Subcategory cat : categoryList)
        {
            response.add(SubcategorylstResponse.builder()
                            .id(cat.getId())
                    .category(cat.getCategory().getCategoryName())
                    .subcategoryName(cat.getSubcategoryName())
                    .noOfProducts(cat.getProductsList().size())
                    .build());
        }
        return response;
    }


    public List<Subcategory> subcategoryList() {
        return subcategoryRepo.findAll();
    }

    public List<SubcategoryResponse> subcategoryByCategory(Integer id){
        Optional<Category> category = categoryRepo.findById(id);
        if(category.isEmpty())
            return null;
        Category catdtl = category.get();
        List<SubcategoryResponse> subcategoryResponseList = new ArrayList<>();
        List<Subcategory> subcategories = subcategoryRepo.findSubcategoryByCategory(catdtl);
        for(Subcategory sub : subcategories)
        {
            subcategoryResponseList.add(SubcategoryResponse.builder()
                            .subcategoryName(sub.getSubcategoryName())
                            .subcategoryId(sub.getId())
                    .build());
        }
        return subcategoryResponseList;
    }
}
