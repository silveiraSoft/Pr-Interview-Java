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

class ParkingLot {
    private int spotsPerFloor;
    private int numberOfFloors;
    private Car[][] parkedCars;

    public ParkingLot(int spotsPerFloor, int numberOfFloors) {
        this.spotsPerFloor = spotsPerFloor;
        this.numberOfFloors = numberOfFloors;
        this.parkedCars = new Car[numberOfFloors][spotsPerFloor];
    }

    public boolean parkCar(Car car) {
        for (int floor = 0; floor < numberOfFloors; floor++) {
            for (int spot = 0; spot < spotsPerFloor; spot++) {
                if (parkedCars[floor][spot] == null) {
                    parkedCars[floor][spot] = car;
                    System.out.println("Car " + car.getLicensePlate() + " parked at Floor " + floor + ", Spot " + spot);
                    return true;
                }
            }
        }
        System.out.println("Parking lot is full!");
        return false;
    }

    public boolean parkCarAt(Car car, int floor, int spot) {
        if (floor >= numberOfFloors || spot >= spotsPerFloor) {
            System.out.println("Invalid location!");
            return false;
        }
        if (parkedCars[floor][spot] != null) {
            System.out.println("Spot already occupied!");
            return false;
        }
        parkedCars[floor][spot] = car;
        System.out.println("Car " + car.getLicensePlate() + " parked at Floor " + floor + ", Spot " + spot);
        return true;
    }

    public boolean removeCar(String licensePlate) {
        for (int floor = 0; floor < numberOfFloors; floor++) {
            for (int spot = 0; spot < spotsPerFloor; spot++) {
                if (parkedCars[floor][spot] != null && 
                    parkedCars[floor][spot].getLicensePlate().equals(licensePlate)) {
                    parkedCars[floor][spot] = null;
                    System.out.println("Car " + licensePlate + " removed from Floor " + floor + ", Spot " + spot);
                    return true;
                }
            }
        }
        System.out.println("Car " + licensePlate + " not found!");
        return false;
    }

    public String findCar(String licensePlate) {
        for (int floor = 0; floor < numberOfFloors; floor++) {
            for (int spot = 0; spot < spotsPerFloor; spot++) {
                if (parkedCars[floor][spot] != null && 
                    parkedCars[floor][spot].getLicensePlate().equals(licensePlate)) {
                    return "Floor " + floor + ", Spot " + spot;
                }
            }
        }
        return "Car not found";
    }

    public int getAvailableSpots() {
        int count = 0;
        for (int floor = 0; floor < numberOfFloors; floor++) {
            for (int spot = 0; spot < spotsPerFloor; spot++) {
                if (parkedCars[floor][spot] == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public void displayStatus() {
        System.out.println("\n=== Parking Lot Status ===");
        System.out.println("Total capacity: " + (spotsPerFloor * numberOfFloors));
        System.out.println("Available spots: " + getAvailableSpots());
        System.out.println("Occupied spots: " + (spotsPerFloor * numberOfFloors - getAvailableSpots()));
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parking = new ParkingLot(3, 2);
        
        Car car1 = new Car("ABC123", "Toyota");
        Car car2 = new Car("XYZ789", "Honda");
        Car car3 = new Car("DEF456", "Ford");
        
        parking.parkCar(car1);
        parking.parkCar(car2);
        parking.parkCarAt(car3, 1, 1);
        
        parking.displayStatus();
        
        System.out.println("\nFinding cars:");
        System.out.println("Car ABC123: " + parking.findCar("ABC123"));
        System.out.println("Car XYZ789: " + parking.findCar("XYZ789"));
        
        parking.removeCar("ABC123");
        parking.displayStatus();
    }
}
