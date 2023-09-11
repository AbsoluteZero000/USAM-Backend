package app.Backend_USAM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.Backend_USAM.entities.Holiday;
import app.Backend_USAM.entities.Repositories.HolidayRepo;
import app.Backend_USAM.util.Request.HolidayCreationRequest;

@RestController
@RequestMapping("/holiday")
public class HolidayController {
@Autowired
    private HolidayRepo holidayRepo;

    public HolidayController(){}

    @GetMapping("/holidays")
    public Iterable<Holiday> getAllHolidays(){
        return holidayRepo.findAll();
    }

    @GetMapping("/holiday")
    public Holiday getHoliday(@RequestParam int id){
        return holidayRepo.findById(id).get();
    }

    @PostMapping("/create")
    public Holiday createHoliday(@RequestBody HolidayCreationRequest req){
        return holidayRepo.save(new Holiday(req));
    }

    @PutMapping("/edit")
    public Holiday editHoliday(@RequestParam int id, @RequestBody HolidayCreationRequest req){
        Holiday holiday = holidayRepo.findById(id).get();
        holiday.edit(req);
        return holidayRepo.save(holiday);
    }
}
