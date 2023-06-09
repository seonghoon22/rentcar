package com.web.service;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.web.domain.Car;


public interface CarService {
    List<Car> getAllCars();
    Car getCarByCar_no(Long car_no);
    void saveCar(Car car, MultipartFile file) throws Exception;

    public List<Car> searchAvailableCars(Date startDate, Date endDate);
    void deleteCar(long car_no);

}