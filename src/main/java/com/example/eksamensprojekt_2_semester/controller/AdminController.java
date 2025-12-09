package com.example.eksamensprojekt_2_semester.controller;

import com.example.eksamensprojekt_2_semester.model.Admin;
import com.example.eksamensprojekt_2_semester.model.Car;
import com.example.eksamensprojekt_2_semester.model.RentalContract;
import com.example.eksamensprojekt_2_semester.model.VehicleReport;
import com.example.eksamensprojekt_2_semester.service.AdminService;
import com.example.eksamensprojekt_2_semester.service.CarService;
import com.example.eksamensprojekt_2_semester.service.RentalContractService;
import com.example.eksamensprojekt_2_semester.service.VehicleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    CarService carService;

    @Autowired
    private RentalContractService rentalContractService;
    @Autowired
    private VehicleReportService vehicleReportService;

    @GetMapping("/login")
    public String login(@RequestParam (value = "error", required = false) String error, Model model){
        if (error != null) {
            model.addAttribute("errorMessage", "Forkert brugernavn eller kodeord");
        }
        return "home/login";
    }

    //Handles login form submission if it fails the user is sent back to login
    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String pwd, RedirectAttributes redirectAttributes) {
        Admin admin = adminService.getAdmin();

        if (admin.getUsername().equals(username) && admin.getPassword().equals(pwd)) {
            return "redirect:/admin_index";
        } else {
            redirectAttributes.addAttribute("error", "true");
            return "redirect:/login";
        }
    }

    @GetMapping ("/admin_index")
    public String admin_index(Model model){
        List<RentalContract> totalRentedCars = rentalContractService.getActiveRentalContracts();
        int averageRentalPeriod = rentalContractService.getAverageRentalPeriod();
        model.addAttribute("totalRentedCars", totalRentedCars);
        model.addAttribute("averageRentalPeriod", averageRentalPeriod);
        return "home/admin_index";
    }

    @GetMapping ("/allCarsAdmin")
    public String allCarsAdmin(Model model){
        List<VehicleReport> vehicleReports = vehicleReportService.getAllVehicleReports();
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        model.addAttribute("vehicleReports", vehicleReports);
        return "home/allCarsAdmin";
    }

    @GetMapping ("/rentals")
    public String todaysRentals(Model model){
        model.addAttribute("todaysRentals", rentalContractService.getTodaysRentals());
        model.addAttribute("todaysReturns", rentalContractService.getTodaysReturns());
        return ("home/todaysRentals");
    }



}
