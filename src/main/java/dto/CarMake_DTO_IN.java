/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.CarMake;
import java.util.List;

/**
 *
 * @author ndupo
 */
public class CarMake_DTO_IN {


    private String name;
    private List<Car_DTO_IN> cars_by_make;
    private List<CarModel_DTO_IN> models_of_make;

    public CarMake_DTO_IN() {
    }

    public CarMake_DTO_IN(CarMake make) {

        this.name = make.getName();
        if (make.getCars_by_make() != null) {
            make.getCars_by_make().forEach((carsByMake) -> {
                this.cars_by_make.add(new Car_DTO_IN(carsByMake));
            });
        }
        if (make.getModels_of_make() != null) {
            make.getModels_of_make().forEach((modelByMake) -> {
                this.models_of_make.add(new CarModel_DTO_IN(modelByMake));
            });
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car_DTO_IN> getCars_by_make() {
        return cars_by_make;
    }

    public void setCars_by_make(List<Car_DTO_IN> cars_by_make) {
        this.cars_by_make = cars_by_make;
    }

    public List<CarModel_DTO_IN> getModels_of_make() {
        return models_of_make;
    }

    public void setModels_of_make(List<CarModel_DTO_IN> models_of_make) {
        this.models_of_make = models_of_make;
    }

}
