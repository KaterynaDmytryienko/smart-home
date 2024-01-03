package smart.home.util;

import smart.home.model.*;

import java.util.ArrayList;
import java.util.List;

public class HouseConfig {

    /**
     * Method defines first house configuration.
     */
    public void setFirstHouseConfig() {
        House house = House.getHouse();
        // Set up the first configuration
        List<Animal> animalsConfig1 = new ArrayList<Animal>() {{
            add(new Animal("cat", "Laska"));
            add(new Animal("dog", "Sharik"));
            add(new Animal("parrot", "Mandarinka"));
        }};
        List<Person> peopleConfig1 = new ArrayList<Person>() {{
            add(new Person("Rachel", "female", 30, true));
            add(new Person("Ross", "male", 38, true));
            add(new Person("Elison", "male", 12, false));
            add(new Person("Tom", "male", 1, false));
            add(new Person("Bella", "female", 16, true));
            add(new Person("Edward", "male", 20, true));
        }};
        List<Item> itemsConfig1 = new ArrayList<Item>() {{
            add(new Item(1, "ball"));
            add(new Item(1, "mouse"));
            add(new Item(1, "feather"));
        }};


        final List<Device> devices = new ArrayList<Device>() {{
            add(new Speakers());
            add(new VacuumCleaner());
        }};

        final List<Device> devices2 = new ArrayList<Device>() {{
            add(new Fridge());
            add(new Multicooker());
            add(new Speakers());
            add(new PetFeeder());
            add(new VacuumCleaner());
        }};
        final List<Device> devices3 = new ArrayList<Device>() {{
            add(new Fridge());
            add(new Treadmill());
            add(new Speakers());
            add(new PetFeeder());
            add(new VacuumCleaner());
        }};

        final List<Device> devices4 = new ArrayList<Device>() {{
            add(new Bicycle());
            add(new Fridge());
            add(new Speakers());
        }};
        final List<Device> devices5 = new ArrayList<Device>() {{
            add(new Treadmill());
            add(new Speakers());
        }};


        final List<Device> devices6 = new ArrayList<Device>() {{
            add(new Bicycle());
            add(new Car());
            add(new Skis());
            add(new Speakers());
        }};

        final List<Device> devices7 = new ArrayList<Device>() {{
            add(new Treadmill());
            add(new PetFeeder());
            add(new Speakers());
        }};


        final Floor floor1 = new Floor(1);
        final Floor floor2 = new Floor(2);
        List<Room> roomsFloor1 = new ArrayList<Room>() {{
            add(new LivingRoom());
            add(new Bathroom(devices));
            add(new Kitchen(devices2));
            add(new BedRoom(devices3));
            add(new Garage(devices6));
        }};

        List<Room> roomsFloor2 = new ArrayList<Room>() {{
            add(new BedRoom(devices4));
            add(new BedRoom(devices5));

        }};

        floor1.setRooms(roomsFloor1);
        floor2.setRooms(roomsFloor2);

        List<Floor> floorsConfig1 = new ArrayList<Floor>() {{
            add(floor1);
            add(floor2);
        }};


        List<Floor> houseFloors = new ArrayList<Floor>();
        houseFloors.add(floor1);
        houseFloors.add(floor2);

        //assigning lists to house
        house.setAnimals(animalsConfig1);
        house.setPeople(peopleConfig1);
        house.setItems(itemsConfig1);
        house.setFloors(houseFloors);
    }


    /**
     * Method defines second house configuration.
     */
    public static void setSecondHouseConfig() {
        House house = House.getHouse();
        List<Animal> animalsConfig2 = new ArrayList<Animal>() {{
            add(new Animal("cat", "Murzik"));
            add(new Animal("dog", "Archi"));
            add(new Animal("parrot", "Mango"));
            add(new Animal("parrot", "Kesha"));
        }};
        List<Person> peopleConfig2 = new ArrayList<Person>() {{
            add(new Person("Gabriel", "male", 25, true));
            add(new Person("Evelina", "female", 23, false));
            add(new Person("Kratos", "male", 9, false));
            add(new Person("Denis", "male", 4, false));
            add(new Person("Rosetta", "female", 40, true));
            add(new Person("Patrick", "male", 50, true));
        }};
        List<Device> devicesForBedroom1 = new ArrayList<Device>() {{
            add(new Speakers());
            add(new VacuumCleaner());
            add(new Treadmill());
        }};

        List<Device> devicesForBedroom2 = new ArrayList<Device>() {{
            add(new Speakers());
            add(new VacuumCleaner());
            add(new Treadmill());
        }};

        List<Device> devicesForBathroom = new ArrayList<Device>() {{
            add(new Speakers());
            add(new VacuumCleaner());
        }};

        List<Device> devicesForBathroom2 = new ArrayList<Device>() {{
            add(new Speakers());
            add(new VacuumCleaner());
        }};


        List<Device> devicesForKitchen = new ArrayList<Device>() {{
            add(new Speakers());
            add(new VacuumCleaner());
            add(new Fridge());
            add(new Multicooker());
        }};

        List<Device> devicesForGarage = new ArrayList<Device>() {{
            add(new Speakers());
            add(new VacuumCleaner());
            add(new Treadmill());
            add(new Car());
            add(new Bicycle());
        }};

        List<Device> devicesForLivingRoom = new ArrayList<Device>() {{
            add(new Speakers());
            add(new VacuumCleaner());
            add(new Treadmill());
        }};

        final Floor floor1 = new Floor(1);
        final Floor floor2 = new Floor(2);

        List<Room> roomsFloor1 = new ArrayList<Room>() {{
            add(new LivingRoom(devicesForLivingRoom));
            add(new Bathroom(devicesForBathroom));
            add(new Kitchen(devicesForKitchen));
            add(new BedRoom(devicesForBedroom1));
            add(new Garage(devicesForGarage));
        }};

        List<Room> roomsFloor2 = new ArrayList<Room>() {{
            add(new Bathroom(devicesForBathroom2));
            add(new BedRoom(devicesForBedroom2));
        }};


        floor1.setRooms(roomsFloor1);
        floor2.setRooms(roomsFloor2);

        List<Floor> houseFloors = new ArrayList<Floor>();
        houseFloors.add(floor1);
        houseFloors.add(floor2);

        //assigning lists to house
        house.setAnimals(animalsConfig2);
        house.setPeople(peopleConfig2);
        house.setFloors(houseFloors);
    }
}