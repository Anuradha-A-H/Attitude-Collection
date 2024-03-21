package Attitude_Collection.AttitudeCollectionOfficePannel.service;

import Attitude_Collection.AttitudeCollectionOfficePannel.entity.Role;
import Attitude_Collection.AttitudeCollectionOfficePannel.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;

    public String addRole(Role role)
    {
        Role newRole = roleRepo.save(role);
        if(newRole == null)
            return "Something Went Wrong";
        return "New Role Addedd Successfully";
    }

    public Role getRoleById(Integer id)
    {
        Optional<Role> role = roleRepo.findById(id);
        if(role.isEmpty())
        {
            return null;
        }
        return role.get();
    }

    public List<Role> allRoles(){
        return  roleRepo.findAll();

    }

    public String deleteRole(Integer id)
    {
        Optional<Role> role = roleRepo.findById(id);
        if(role.isEmpty())
        {
            return "Invalid Id Entered";
        }
        roleRepo.deleteById(id);
        return "Deleted Successfully";
    }
}
