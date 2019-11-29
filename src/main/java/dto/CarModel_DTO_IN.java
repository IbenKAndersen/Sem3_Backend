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
public class CarModel_DTO_IN {

    private List<Car_DTO_IN> cars;
    private CarMake_DTO_IN make;
    private String name;

    public CarModel_DTO_IN() {
    }

    public CarModel_DTO_IN(CarModel model) {
        if (model.getModel_of_car() != null) {
            model.getModel_of_car().forEach((carsOfModel) -> {
                this.cars.add(new Car_DTO_IN(carsOfModel));
            });
        }
        this.make = new CarMake_DTO_IN(model.getMake());
        this.name = model.getName();
    }


    public List<Car_DTO_IN> getCars() {
        return cars;
    }

    public void setCars(List<Car_DTO_IN> cars) {
        this.cars = cars;
    }

    public CarMake_DTO_IN getMake() {
        return make;
    }

    public void setMake(CarMake_DTO_IN make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
