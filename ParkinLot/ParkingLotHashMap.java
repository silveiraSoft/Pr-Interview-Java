import java.util.*;

class Car {
    private String licensePlate;
    private String model;

    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }
}

class ParkingSpot {
    private int slotNumber;
    private int floor;
    private int spot;
    private Car car;

    public ParkingSpot(int slotNumber, int floor, int spot) {
        this.slotNumber = slotNumber;
        this.floor = floor;
        this.spot = spot;
    }

    public void parkCar(Car car) {
        this.car = car;
    }

    public void removeCar() {
        this.car = null;
    }

    public boolean isAvailable() {
        return car == null;
    }

    public Car getCar() {
        return car;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public String getLocation() {
        return "Slot #" + slotNumber + " (Floor " + floor + ", Spot " + spot + ")";
    }
}

class ParkingLot {
    private int totalCapacity;
    private Map<String, ParkingSpot> carToSpotMap;
    private Map<Integer, ParkingSpot> slotToSpotMap;
    private Queue<Integer> availableSlots;

    public ParkingLot(int spotsPerFloor, int numberOfFloors) {
        this.totalCapacity = spotsPerFloor * numberOfFloors;
        this.carToSpotMap = new HashMap<>();
        this.slotToSpotMap = new HashMap<>();
        this.availableSlots = new LinkedList<>();

        int slotNumber = 1;
        for (int floor = 0; floor < numberOfFloors; floor++) {
            for (int spot = 0; spot < spotsPerFloor; spot++) {
                ParkingSpot parkingSpot = new ParkingSpot(slotNumber, floor, spot);
                slotToSpotMap.put(slotNumber, parkingSpot);
                availableSlots.offer(slotNumber);
                slotNumber++;
            }
        }
    }

    public boolean parkCar(Car car) {
        if (availableSlots.isEmpty()) {
            System.out.println("Parking lot is full!");
            return false;
        }

        int slotNumber = availableSlots.poll();
        ParkingSpot spot = slotToSpotMap.get(slotNumber);
        spot.parkCar(car);
        carToSpotMap.put(car.getLicensePlate(), spot);
        System.out.println("Car " + car.getLicensePlate() + " parked at " + spot.getLocation());
        return true;
    }

    public boolean parkCarAt(Car car, int slotNumber) {
        if (!slotToSpotMap.containsKey(slotNumber)) {
            System.out.println("Invalid slot number!");
            return false;
        }

        ParkingSpot spot = slotToSpotMap.get(slotNumber);
        if (!spot.isAvailable()) {
            System.out.println("Slot already occupied!");
            return false;
        }

        spot.parkCar(car);
        carToSpotMap.put(car.getLicensePlate(), spot);
        availableSlots.remove(slotNumber);
        System.out.println("Car " + car.getLicensePlate() + " parked at " + spot.getLocation());
        return true;
    }

    public boolean removeCar(String licensePlate) {
        ParkingSpot spot = carToSpotMap.get(licensePlate);
        if (spot == null) {
            System.out.println("Car " + licensePlate + " not found!");
            return false;
        }

        spot.removeCar();
        carToSpotMap.remove(licensePlate);
        availableSlots.offer(spot.getSlotNumber());
        System.out.println("Car " + licensePlate + " removed from " + spot.getLocation());
        return true;
    }

    public String findCar(String licensePlate) {
        ParkingSpot spot = carToSpotMap.get(licensePlate);
        return spot != null ? spot.getLocation() : "Car not found";
    }

    public int getAvailableSpots() {
        return availableSlots.size();
    }

    public void displayStatus() {
        System.out.println("\n=== Parking Lot Status ===");
        System.out.println("Total capacity: " + totalCapacity);
        System.out.println("Available spots: " + getAvailableSpots());
        System.out.println("Occupied spots: " + (totalCapacity - getAvailableSpots()));
    }
}

public class ParkingLotHashMap {
    public static void main(String[] args) {
        ParkingLot parking = new ParkingLot(3, 2);
        
        Car car1 = new Car("ABC123", "Toyota");
        Car car2 = new Car("XYZ789", "Honda");
        Car car3 = new Car("DEF456", "Ford");
        
        parking.parkCar(car1);
        parking.parkCar(car2);
        parking.parkCarAt(car3, 4);
        
        parking.displayStatus();
        
        System.out.println("\nFinding cars:");
        System.out.println("Car ABC123: " + parking.findCar("ABC123"));
        System.out.println("Car XYZ789: " + parking.findCar("XYZ789"));
        
        parking.removeCar("ABC123");
        parking.displayStatus();
    }
}
