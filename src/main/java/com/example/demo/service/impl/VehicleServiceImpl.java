@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository v;

    public VehicleServiceImpl(VehicleRepository v) {
        this.v = v;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return v.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return v.findById(id).orElse(null);
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        return v.findByVin(vin);   
    }

    @Override
    public List<Vehicle> getVehicleByOwner(Long ownerId) {
        return v.findAll();
    }

    @Override
    public void deactivateVehicle(Long id) {
        Vehicle vehicle = v.findById(id).orElse(null);
        if (vehicle != null) {
            vehicle.setActive(false);
            v.save(vehicle);
        }
    }
}
