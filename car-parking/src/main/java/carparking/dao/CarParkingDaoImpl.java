package carparking.dao;
import carparking.dao.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarParkingDaoImpl implements CarParkingDaoService{
    @Autowired ParkingRepository parkingRepository;

    @Override
    public void save() {
    }
}
