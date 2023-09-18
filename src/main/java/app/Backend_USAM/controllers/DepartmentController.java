package app.Backend_USAM.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Backend_USAM.controllers.Request.CreationRequest.DepartmentCreationRequest;
import app.Backend_USAM.entities.Department;
import app.Backend_USAM.entities.User;
import app.Backend_USAM.entities.Repositories.DepartmentRepo;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/dep")
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentRepo DepartmentRepo;
    @Autowired
    private UserController userController;

    @PostMapping("/create")
    public Department createDepartment(@RequestBody DepartmentCreationRequest req){
        Department dep = new Department(req);
        User user = userController.getUser(req.getStaffId());
        user.setDepartmentId(dep.getId());
        dep.setHeadId(req.getStaffId());
        userController.editUser(user);
        return DepartmentRepo.save(dep);
    }

    @GetMapping("/departments")
    public Iterable<Department> getAllDepartments()
    {
        return DepartmentRepo.findAll();
    }
    @GetMapping("/department")
    public Department getDepartment(@RequestParam int id){
        return DepartmentRepo.findById(id).get();
    }

    @GetMapping("/departmentbyname")
    public Department getDepartmentByName(@RequestParam String name){
        return DepartmentRepo.findByName(name).get();
    }

    @PutMapping("/edit")
    public Department editDepartment(@RequestParam int id, @RequestBody DepartmentCreationRequest req){


        Department Department = DepartmentRepo.findById(id).get();
        Department.edit(req);
        return DepartmentRepo.save(Department);
    }

    @DeleteMapping("/delete")
    public void deleteDepartment(@RequestParam int id){
        Department Department = DepartmentRepo.findById(id).get();
        DepartmentRepo.delete(Department);
    }



}
