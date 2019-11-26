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
public class CarMake_DTO {

    private int id;
    private String name;
    private List<Car_DTO> cars_by_make;
    private List<CarModel_DTO> models_of_make;

    public CarMake_DTO() {
    }

    public CarMake_DTO(CarMake make) {
        this.id = make.getId();
        this.name = make.getName();
        if (make.getCars_by_make() != null) {
            make.getCars_by_make().forEach((carsByMake) -> {
                this.cars_by_make.add(new Car_DTO(carsByMake));
            });
        }
        if (make.getModels_of_make() != null) {
            make.getModels_of_make().forEach((modelByMake) -> {
                this.models_of_make.add(new CarModel_DTO(modelByMake));
            });
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car_DTO> getCars_by_make() {
        return cars_by_make;
    }

    public void setCars_by_make(List<Car_DTO> cars_by_make) {
        this.cars_by_make = cars_by_make;
    }

    public List<CarModel_DTO> getModels_of_make() {
        return models_of_make;
    }

    public void setModels_of_make(List<CarModel_DTO> models_of_make) {
        this.models_of_make = models_of_make;
    }

}
