package app.Backend_USAM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.Backend_USAM.entities.Department;
import app.Backend_USAM.entities.Repositories.DepartmentRepo;
import app.Backend_USAM.util.Request.DepartmentCreationRequest;

@RestController
@RequestMapping("/dep")
public class DepartmentController {

    @Autowired
    private DepartmentRepo depRepo;

    public DepartmentController(){}

    @GetMapping("/deps")
    public Iterable<Department> getAllDepartments(){
        return depRepo.findAll();
    }

    @GetMapping("/dep")
    public Department getDepartment(@RequestParam int id){
        return depRepo.findById(id).get();
    }

    @PostMapping("/create")
    public Department createDepartment(@RequestBody DepartmentCreationRequest req){
        return depRepo.save(new Department(req));
    }

    @PutMapping("/edit")
    public Department editDepartment(@RequestParam int id, @RequestBody DepartmentCreationRequest req){
        Department dep = depRepo.findById(id).get();
        dep.edit(req);
        return depRepo.save(dep);
    }
}
