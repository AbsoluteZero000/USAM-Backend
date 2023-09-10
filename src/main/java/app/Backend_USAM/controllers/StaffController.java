package app.Backend_USAM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Backend_USAM.entities.Staff;
import app.Backend_USAM.entities.Repositories.StaffRepo;
import app.Backend_USAM.util.Request.StaffCreationRequest;

@RestController
@RequestMapping("/staff")
public class StaffController {
@Autowired
    StaffRepo staffRepo;

    public StaffController(){}

    @PostMapping("/create")
    public String test(@RequestBody StaffCreationRequest req){

        staffRepo.save(new Staff(req));
        return "test";
    }

    @GetMapping("/staff")
    public Iterable<Staff> getAllStaffs()
    {
        return staffRepo.findAll();
    }
    @GetMapping("/singleStaff")
    public Staff getStaff(@RequestParam int id){
        return staffRepo.findById(id).get();
    }

    @PutMapping("/edit")
    public Staff editStaff(@RequestParam int id, @RequestBody StaffCreationRequest req){
        Staff staff = staffRepo.findById(id).get();
        staff.edit(req);
        return staffRepo.save(staff);
    }

}
