package Attitude_Collection.AttitudeCollectionOfficePannel.controller;


import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import Attitude_Collection.AttitudeCollectionOfficePannel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @PostMapping("addRole")
    public String addRole(@ModelAttribute Role role){
        String msg = roleService.addRole(role);
        return "redirect:/roles/";
    }

    @GetMapping("loadRole")
    public String loadRole(){
        return "addrole";
    }

    @GetMapping("loadUpdateRole/{id}")
    public String loadUpdateRole(@PathVariable Integer id,Model m){
        Role role = roleService.getRoleById(id);
        m.addAttribute("roledtl",role);
        return "updateRole";
    }

    @GetMapping("/")
    public String allRoles(Model m){
        List<Role> roleList = roleService.allRoles();
        m.addAttribute("allrole",roleList);
        return "roles";
    }

    @PutMapping("/updateRole")
    public String updateRole(@ModelAttribute Role role){
        String msg = roleService.addRole(role);
        return "redirect:/roles/";
    }

    @DeleteMapping("loadDeleteRole/{id}")
    public String loadDeleteRole(@PathVariable Integer id){
        String role = roleService.deleteRole(id);
        return "redirect:/";
    }




}
