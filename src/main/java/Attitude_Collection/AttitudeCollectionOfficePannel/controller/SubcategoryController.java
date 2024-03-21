package Attitude_Collection.AttitudeCollectionOfficePannel.controller;



import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Category;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.SubcategoryRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.SubcategorylstResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.CategoryService;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("subcategory")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/")
    public  String allSubcategory(Model m){
        List<SubcategorylstResponse> responses = subcategoryService.allSubcategory();
        m.addAttribute("subcat",responses);
        return "subcategory";
    }

    @PostMapping("/addsubcategory")
    public String addSubcategory(@ModelAttribute SubcategoryRequest request){
        String msg = subcategoryService.addSubcategory(request);
        return "redirect:/subcategory/";
    }

    @GetMapping("/loadsubcategory")
    public String loadsubcategory(Model m){
        List<Category> categoryList = categoryService.allCategory();
        m.addAttribute("allcat",categoryList);
        return "addsubcategory";
    }


}
