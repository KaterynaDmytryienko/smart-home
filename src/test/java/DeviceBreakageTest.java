import org.junit.Test;
import smart.home.event.Even_Types;
import smart.home.event.Event;
import smart.home.event.EventManager;
import smart.home.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DeviceBreakageTest {
    @Test
    public void petFeederBreakageTest(){
        House house = House.getHouse();
        Person person=new Person("Ally","female",30,false);
        Floor floor = new Floor(1);
        Room room = new LivingRoom();
        Device device = new PetFeeder();
        device.setFunctionality(0);
        List<Person> people = new ArrayList<>();
        List<Floor>floors = new ArrayList<>();
        List<Room>rooms = new ArrayList<>();

        List<Device>devices = new ArrayList<>();
        devices.add(device);

        floors.add(floor);
        people.add(person);
        house.setPeople(people);
        house.setFloors(floors);
        house.setDevices(devices);
        floor.setRooms(rooms);
        Event event=new Event(Even_Types.DEVICE_BREAKAGE,device,room);
        EventManager eventManager=new EventManager();
        eventManager.handleEvent(event);

        assertTrue(event.isHandled);

    }
}
