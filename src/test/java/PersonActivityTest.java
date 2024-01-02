
import org.junit.Test;
import smart.home.activity.PersonActivity;
import smart.home.event.*;

import smart.home.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonActivityTest {
    House house=House.getHouse();

    @Test
    public void personDrinkingTest(){
        Person person=new Person("Ally","female",30,false);
        Floor floor = new Floor(1);
        Room room = new LivingRoom();
        List<Person> people = new ArrayList<>();
        List<Floor>floors = new ArrayList<>();
        List<Room>rooms = new ArrayList<>();

        floors.add(floor);
        people.add(person);
        house.setPeople(people);
        house.setFloors(floors);
        floor.setRooms(rooms);
        Event event=new Event(Even_Types.PERSON_THIRSTY,person,room);
        EventManager eventManager=new EventManager();
        eventManager.handleEvent(event);

        assertTrue(event.isHandled);

    }

    @Test
    public void personWorksOutTest(){
        Person person=new Person("Ally","female",30,false);
        Floor floor = new Floor(1);
        Room room = new LivingRoom();
        List<Person> people = new ArrayList<>();
        List<Floor>floors = new ArrayList<>();
        List<Room>rooms = new ArrayList<>();

        floors.add(floor);
        people.add(person);
        house.setPeople(people);
        house.setFloors(floors);
        floor.setRooms(rooms);
        Event event=new Event(Even_Types.WORKOUT,person,room);
        EventManager eventManager=new EventManager();
        eventManager.handleEvent(event);

        assertTrue(event.isHandled);

    }
}
