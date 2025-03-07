package smart.home.model;

import org.slf4j.LoggerFactory;
import smart.home.event.Event;

import java.util.Random;

public class PetFeeder extends Device {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PetFeeder.class);
    House house = House.getHouse();

    public PetFeeder() {
        super();
        Consumption activeConsumption = new Consumption(200, 0, 300);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption = new Consumption(0, 0, 0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption = new Consumption(100, 0, 100);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.IDLE);
    }

    /**
     * Method picks PetFeeder from a random room and assigns pet that has used it.
     *
     * @param animalName
     */
    public void getRandomDevice(String animalName) {
        Random random = new Random();
        if (random.nextBoolean()) {
            for (Device d : house.getDevices()) {
                if (d instanceof PetFeeder) {
                    d.setCurrentState(DeviceState.ACTIVE);
                    d.addUser(animalName);
                    break;
                }
            }
        } else {
            for (int i = house.getDevices().size() - 1; i >= 0; i--) {
                if (house.getDevices().get(i) instanceof PetFeeder) {
                    house.getDevices().get(i).setCurrentState(DeviceState.ACTIVE);
                    house.getDevices().get(i).addUser(animalName);
                    break;
                }
            }
        }
    }

    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            LOGGER.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }

        switch (event.getType()) {
            case ANIMAL_HUNGRY:
                System.out.println(event.getSource().getName() + " is currently being fed.");
                getRandomDevice(event.getSource().getName());
                event.isHandled = true;
                break;
            case ANIMAL_THIRSTY:
                System.out.println(event.getSource().getName() + " is currently drinking water.");
                getRandomDevice(event.getSource().getName());
                event.isHandled = true;
                break;

        }
    }
}
