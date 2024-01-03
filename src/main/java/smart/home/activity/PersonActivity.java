package smart.home.activity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smart.home.event.EventManager;
import smart.home.event.EventTypes;
import smart.home.event.Event;
import smart.home.model.*;

import java.util.List;
import java.util.Random;

public class PersonActivity implements Activity {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonActivity.class);
    House house = House.getHouse();
    private List<Person> people = house.getPeople();

    public List<Person> getPeople() {
        return people;
    }
    /**
     * Method generates random events on a random floor in a random room
     * considering 50/50 ratio of sport and other events.
     *
     * @param sportEvent A boolean flag indicating whether the generated event is sport-related.
     * @return An instance of the Event representing the randomly generated event.
     */
    @Override
    public Event doSomething(boolean sportEvent) {
        EventManager eventManager=house.getEventManager();
        Random rand = new Random();
        Person selectedPerson = people.get(rand.nextInt(people.size()));

        EventTypes[] events = EventTypes.values();

        int min = eventManager.getFIRST_PERSON_EVENT_INDEX();
        int max = eventManager.getLAST_PERSON_EVENT_INDEX();
        if (sportEvent) {
            min = eventManager.getFIRST_SPORT_EVENT_INDEX();
            max = eventManager.getLAST_SPORT_EVENT_INDEX();
        }
        int range = max - min + 1;
        int eventIndex = rand.nextInt(range) + min;

        List<Floor> floors = house.getFloors();
        int floorIndex = rand.nextInt(floors.size());

        List<Room> rooms = house.getRooms(floorIndex);
        int roomIndex = rand.nextInt(rooms.size());

        return new Event(events[eventIndex], selectedPerson, rooms.get(roomIndex));
    }

    /**
     * Method allows a person to fix a device, with the help of a manual.
     *
     * @param person person The person attempting to fix the device.
     * @param device The device to be fixed.
     */
    public void fixDevice(Person person, Device device) {
        if (device != null) {
            LOGGER.info(person.getName() + " wants to fix the " + device.getName(device));
            LOGGER.info("Reading Manual:...\n..."
                    + device.getDocumentation().getDocumentationManual());
            LOGGER.info(device.getName(device) + " was fixed!");
            device.setFunctionality(100);
            device.setCurrentState(Device.DeviceState.IDLE);
        }
    }

    /**
     * Method allows a person to help a child, if it is crying.
     *
     * @param person The person helping the crying child.
     */
    public void helpTheChild(Person person) {
        LOGGER.info(person.getName() + " is helping the child...");
    }

    /**
     * Method allows a person to eat and makes another person wait until the first person finishes eating.
     * If there is a person selected to wait, this method will recursively call itself to allow the waiting person
     * to eat once the first person has finished.
     *
     * @param person The person who is currently eating.
     * @param selectedToWait The person selected to wait until the first person finishes eating.
     */
    public void eat(Person person, Person selectedToWait) {

        LOGGER.info(person.getName() + " is eating.");
        if (selectedToWait != null) {
            LOGGER.info(selectedToWait.getName() + " is waiting on " + person.getName() + " to finish eating.");

        }
        for (Device d : house.getDevices()) {
            if (d instanceof Fridge) {
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName() + " finished eating.");
        if (selectedToWait != null) {
            eat(selectedToWait, null);
        }
    }

    /**
     * Method allows a person to drink.
     *
     * @param person The person who is currently drinking.
     */
    public void drink(Person person) {
        LOGGER.info(person.getName() + " is drinking.");
        for (Device d : house.getDevices()) {
            if (d instanceof Fridge) {
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
    }

    /**
     * Method allows a person to play.
     *
     * @param person The person who is currently playing.
     */
    public void play(Person person) {
        LOGGER.info(person.getName() + " is playing...");
    }

    /**
     * Method allows a person to open a fridge.
     *
     * @param person The person who is currently opening a fridge.
     */
    public void openFridge(Person person) {
        LOGGER.info("Opening fridge..." + person.getName());
    }

    /**
     * Method allows a person to use a treadmill.
     * If there is a person selected to wait, this method will recursively call itself to allow the waiting person
     * to use a treadmill once the first person has finished.
     *
     * @param person The person who is currently using a treadmill.
     * @param selectedToWait The person selected to wait until the first person finishes using a treadmill.
     */
    public void useTreadmill(Person person, Person selectedToWait) {
        LOGGER.info(person.getName() + " is using a treadmill.");
        if (selectedToWait != null) {
            LOGGER.info(selectedToWait.getName() + " is waiting on " + person.getName() + " to finish using treadmill.");

        }
        for (Device d : house.getDevices()) {
            if (d instanceof Treadmill) {
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName() + " finished using treadmill.");
        if (selectedToWait != null) {
            useTreadmill(selectedToWait, null);
        }
    }

    /**
     * Method allows a person to listen to music.
     *
     * @param person The person who is currently using a listening to music.
     */
    public void listenToMusic(Person person) {
        LOGGER.info(person.getName() + " is listening to the music via speakers.");
        for (Device d : house.getDevices()) {
            if (d instanceof Speakers) {
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName() + " finished listening to music.");
    }

    /**
     * Method allows a person to ski.
     * If there is a person selected to wait, this method will recursively call itself to allow the waiting person
     * to ski once the first person has finished.
     *
     * @param person The person who is currently skiing.
     * @param selectedToWait The person selected to wait until the first person finishes skiing.
     */
    public void ski(Person person, Person selectedToWait) {
        LOGGER.info(person.getName() + " is skiing.");
        if (selectedToWait != null) {
            LOGGER.info(selectedToWait.getName() + " is waiting on " + person.getName() + " to finish skiing");

        }
        for (Device d : house.getDevices()) {
            if (d instanceof Skis) {
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName() + " finished skiing.");
        if (selectedToWait != null) {
            ski(selectedToWait, null);
        }
    }

    /**
     * Method allows a person who has driving license to drive.
     * If the person does not have a driving license, warning will be shown.
     *
     * @param person The person who is currently driving.
     */
    public void drive(Person person) {
        if (person.isHasDriveLicense()) {
            LOGGER.info(person.getName() + " is driving.");
            for (Device d : house.getDevices()) {
                if (d instanceof Car) {
                    d.addUser(person.getName());
                    d.setCurrentState(Device.DeviceState.ACTIVE);
                    break;
                }
            }
            LOGGER.info(person.getName() + " finished driving.");
        } else {
            LOGGER.warn(person.getName() + " who does not have driving license trying to use a car!");
        }
    }

    /**
     * Method allows a person to workout.
     *
     * @param person The person who is currently working out.
     */
    public void workout(Person person) {
        LOGGER.info(person.getName() + " is working out.");
        LOGGER.info(person.getName() + " finished working out.");
    }

    /**
     * Method allows a person to cycle.
     * If there is a person selected to wait, this method will recursively call itself to allow the waiting person
     * to cycle once the first person has finished.
     *
     * @param person The person who is currently cycling.
     * @param selectedToWait The person selected to wait until the first person finishes cycling.
     */
    public void cycle(Person person, Person selectedToWait) {
        LOGGER.info(person.getName() + " is cycling.");
        if (selectedToWait != null) {
            LOGGER.info(selectedToWait.getName() + " is waiting on " + person.getName() + " to finish cycling");

        }
        for (Device d : house.getDevices()) {
            if (d instanceof Bicycle) {
                d.addUser(person.getName());
                d.setCurrentState(Device.DeviceState.ACTIVE);
                break;
            }
        }
        LOGGER.info(person.getName() + " finished cycling.");
        if (selectedToWait != null) {
            cycle(selectedToWait, null);
        }
    }
}
