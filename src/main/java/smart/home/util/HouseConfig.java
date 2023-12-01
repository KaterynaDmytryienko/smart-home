package smart.home.util;

import smart.home.model.*;

import java.util.ArrayList;
import java.util.List;

public class HouseConfig {

    public void setFirstHouseConfig(){
        House house=House.getHouse();
        // Set up the first configuration
        List<Animal> animalsConfig1 =new ArrayList<Animal>(){{
            add(new Animal("cat", "Laska"));
            add(new Animal("dog", "Sharik"));
            add(new Animal("parrot", "Mandarinka"));
        }};
        List<Person> peopleConfig1 = new ArrayList<Person>(){{
            add(new Person("Rachel","female", 30, true ));
            add(new Person("Ross","male", 38, true ));
            add(new Person("Elison","male", 12, false ));
            add(new Person("Tom","male", 1, false ));
            add(new Person("Bella","female", 16, true));
            add(new Person("Edward","male", 20, true));
        }};
//        List<Device> devicesConfig1 = /* Your list of devices for config 1 */;
//        List<Sensor> sensorsConfig1 = new ArrayList<Sensor>(){{
//            add()
//        }};
        List<Item> itemsConfig1 = new ArrayList<Item>(){{
            add(new Item(1, "apple"));
        }};
        final LivingRoom livingRoom = new LivingRoom();
        livingRoom.setEmpty(false);

        final Garage garage = new Garage();
        List<Bicycle>bicycles = new ArrayList<Bicycle>(){{
            add(new Bicycle());
            add(new Bicycle());
        }};
        List<Car>cars = new ArrayList<Car>(){{
            add(new Car());
            add(new Car());
        }};

        garage.setBicycles(bicycles);
        garage.setCars(cars);
//        List<Room> roomsConfig1 = new ArrayList<Room>(){{
//            add(livingRoom);
//            add(new Bathroom());
//            add(new Kitchen());
//            add(new BedRoom());
//            add(new BedRoom());
//            add(new BedRoom());
//            add(garage);
//        }};

        final Floor floor1 = new Floor(1);
        final Floor floor2 = new Floor(2);
        List<Room> roomsFloor1 = new ArrayList<Room>(){{
            add(livingRoom);
            add(new Bathroom());
            add(new Kitchen());
            add(new BedRoom());}};

        List<Room> roomsFloor2 = new ArrayList<Room>(){{
            add(new BedRoom());
            add(new BedRoom());
            add(garage);}};

        floor1.setRooms(roomsFloor1);
        floor2.setRooms(roomsFloor2);

        List<Floor> floorsConfig1 = new ArrayList<Floor>(){{
            add(floor1);
            add(floor2);

        }};

        List<Floor> houseFloors = new ArrayList<Floor>();
        houseFloors.add(floor1);
        houseFloors.add(floor2);


        //assigning lists to house
        house.setAnimals(animalsConfig1);
        house.setPeople(peopleConfig1);
//        house.setDevices(devicesConfig1);
//        house.setSensors(sensorsConfig1);
        house.setItems(itemsConfig1);
        house.setFloors(houseFloors);
    }

//    public static void setSecondHouseConfig() {
//        House house = House.getHouse();
//
//        // Set up the second configuration
//        List<Animal> animalsConfig2 = /* Your list of animals for config 2 */;
//        List<Person> peopleConfig2 = /* Your list of people for config 2 */;
//        List<Device> devicesConfig2 = /* Your list of devices for config 2 */;
//        List<Sensor> sensorsConfig2 = /* Your list of sensors for config 2 */;
//        List<Item> itemsConfig2 = /* Your list of items for config 2 */;
//        List<Room> roomsConfig2 = /* Your list of rooms for config 2 */;
//        List<Floor> floorsConfig2 = /* Your list of floors for config 2 */;
//
//        house.setAnimals(animalsConfig2);
//        house.setPeople(peopleConfig2);
//        house.setDevices(devicesConfig2);
//        house.setSensors(sensorsConfig2);
//        house.setItems(itemsConfig2);
//        house.setRooms(roomsConfig2);
//        house.setFloors(floorsConfig2);
//    }
}