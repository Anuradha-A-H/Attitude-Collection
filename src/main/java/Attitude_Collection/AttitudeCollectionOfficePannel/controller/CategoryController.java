package Attitude_Collection.AttitudeCollectionOfficePannel.controller;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Category;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.CategoryResponse;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.CategoryService;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("addCategory")
    public String addCategory(@ModelAttribute Category category){
        String msg = categoryService.addCategory(category);
        return "redirect:/category/";
    }

    @GetMapping("loadCategory")
    public String loadCategory(){
        return "addcategory";
    }

    @GetMapping("loadUpdateCategory/{id}")
    public String loadUpdateCategory(@PathVariable Integer id, Model m){
        Category category = categoryService.getCategoryById(id);
        m.addAttribute("categorydtl",category);
        return "updateRole";
    }

    @GetMapping("/")
    public String allCategory(Model m){
        List<Category> allCategory = categoryService.allCategory();
        m.addAttribute("allcat",allCategory);
        return "category";
    }

    @PutMapping("/updateCategory")
    public String updateCategory(@ModelAttribute Category category){
        String msg = categoryService.addCategory(category);
        return "redirect:/category/";
    }

    @DeleteMapping("loadDeleteCategory/{id}")
    public String loadDeleteCategory(@PathVariable Integer id){
        String role = categoryService.deleteCategory(id);
        return "redirect:/category/";
    }

    @GetMapping("/rest")
    public ResponseEntity getAllCategory(){
        List<CategoryResponse> list = categoryService.allCategoryList();
        return new ResponseEntity(list, HttpStatus.OK);
    }

}
