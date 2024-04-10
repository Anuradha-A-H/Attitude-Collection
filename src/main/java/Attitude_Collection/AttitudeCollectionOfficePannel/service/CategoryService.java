package Attitude_Collection.AttitudeCollectionOfficePannel.service;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Category;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.CategoryRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public String addCategory(Category category)
    {
        Category cat = categoryRepo.save(category);
        if(cat == null)
            return "Something went wrong";
        return "Category Addedd Successfully";
    }

    public Category getCategoryById(Integer id)
    {
        return categoryRepo.findById(id).get();
    }

    public String deleteCategory(Integer id)
    {
        Optional<Category> category = categoryRepo.findById(id);
        if(category.isEmpty())
            return "Invalid Id Entered";
        categoryRepo.deleteById(id);
        return "Category Deleted Successfully";
    }


    public List<Category> allCategory()
    {
        return categoryRepo.findAll();
    }

    public List<CategoryResponse> allCategoryList(){
        List<CategoryResponse> list = new ArrayList<>();
        List<Category> categoryList = categoryRepo.findAll();
        for(Category cat : categoryList)
        {
            list.add(new CategoryResponse(cat.getId(), cat.getCategoryName(),cat.getImage()));
        }
        return list;
    }

}
