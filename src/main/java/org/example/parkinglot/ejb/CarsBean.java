package org.example.parkinglot.ejb;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.parkinglot.common.CarDto;
import org.example.parkinglot.entities.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());
    @PersistenceContext
    EntityManager entityManager;
    List<Cars> carsList;
    public List<CarDto> copyCarsToDto(List<Cars>carList) {
        List<CarDto> dtoList = new ArrayList<>();
        for(Cars c : carList){
            Long carId=c.getId();
            String licensePlate=c.getLicensePlate();
            dtoList.add(new CarDto(licensePlate,carId, c.getParkingSpot(), c.getOwner().getUsername()));
        }
        return dtoList;
    }
    public List<CarDto> findAllCars(){
        LOG.info("findAllCars");
        try{
            TypedQuery<Cars> typedQuery=entityManager.createQuery("SELECT c FROM Cars c", Cars.class);
            List<Cars> cars=typedQuery.getResultList();
            return copyCarsToDto(cars);
        }
        catch(Exception ex){
            throw new EJBException(ex);
        }
    }
}
