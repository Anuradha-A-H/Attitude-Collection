package Attitude_Collection.AttitudeCollectionOfficePannel.controller;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import Attitude_Collection.AttitudeCollectionOfficePannel.entity.User;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.RoleRepository;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.NewDeliveryboyRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.request.NewUserRequest;
import Attitude_Collection.AttitudeCollectionOfficePannel.response.DeliveryBoyResponseList;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.DeliveryBoyService;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/deliveryboy")
public class DeliveryBoyController {

    @Autowired
    private DeliveryBoyService deliveryBoyService;
    @Autowired
    private RoleService roleService;


    @PostMapping("addDeliveryboy")
    public String addDeliveryboy(@ModelAttribute NewDeliveryboyRequest category){
        String msg = deliveryBoyService.addDeliveryboy(category);
        return "redirect:/deliveryboy/";
    }

    @GetMapping("loadDeliveryboy")
    public String loadDeliveryboy(Model m){
        List<Role> roleList = roleService.allRoles();
        m.addAttribute("roleList" ,roleList);
        return "adddeliveryboy";
    }

    @GetMapping("loadDeliveryboy/{id}")
    public String loadDeliveryboy(@PathVariable Integer id, Model m){
        User deliveryboy = deliveryBoyService.getDeliveryboyById(id);
        m.addAttribute("deliveryboy",deliveryboy);
        return "updateRole";
    }

    @GetMapping("/")
    public String allDeliveryboy(Model m){
        List<User> deliveryboyList = deliveryBoyService.allDeliveryboy();
        m.addAttribute("resp",deliveryboyList);
        return "deliveryboy";
    }

//    @PutMapping("/updateCategory")
//    public String updateCategory(@ModelAttribute Category category){
//        String msg = categoryService.addCategory(category);
//        return "redirect:/category/";
//    }

//    @DeleteMapping("loadDeleteCategory/{id}")
//    public String loadDeleteCategory(@PathVariable Integer id){
//        String role = categoryService.deleteCategory(id);
//        return "redirect:/category/";
//    }
}
