package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.domain.Car;
import com.web.service.CarService;

@Controller
//@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
       System.out.println("create CarController");
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {
       System.out.println("@GetMapping(\"/cars\")");
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "car-list";
    }

    @GetMapping("/cars/new")
    public String showCarForm(Model model) {
       System.out.println("@GetMapping(\"/cars\")22");
        model.addAttribute("car", new Car());
        return "car-form";
    }

    @PostMapping("/cars/new")
    public String saveCar(@Valid @ModelAttribute Car car, BindingResult bindingResult,
                          @RequestParam("file") MultipartFile file) throws IOException {
       System.out.println("@GetMapping(\"/cars\")33");
        if (bindingResult.hasErrors()) {
            return "car-form";
        }

		/* car.setFile(file); */
        carService.saveCar(car);
        return "redirect:/cars";
    }

    @GetMapping("/cars/{carNo}")
    public String getCarDetails(@PathVariable("carNo") Long car_no, Model model) {
       System.out.println("@GetMapping(\"/cars\")44");
        Car car = carService.getCarByCar_no(car_no);
        model.addAttribute("car", car);
        return "car-details";
    }
}