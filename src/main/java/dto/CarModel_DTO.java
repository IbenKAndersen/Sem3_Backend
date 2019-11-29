/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.CarModel;
import java.util.List;

/**
 *
 * @author ndupo
 */
public class CarModel_DTO {

    private List<Car_DTO> cars;
    private CarMake_DTO make;
    private String name;

    public CarModel_DTO() {
    }

    public CarModel_DTO(CarModel model) {
        if (model.getModel_of_car() != null) {
            model.getModel_of_car().forEach((carsOfModel) -> {
                this.cars.add(new Car_DTO(carsOfModel));
            });
        }
        this.make = new CarMake_DTO(model.getMake());
        this.name = model.getName();
    }


    public List<Car_DTO> getCars() {
        return cars;
    }

    public void setCars(List<Car_DTO> cars) {
        this.cars = cars;
    }

    public CarMake_DTO getMake() {
        return make;
    }

    public void setMake(CarMake_DTO make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
