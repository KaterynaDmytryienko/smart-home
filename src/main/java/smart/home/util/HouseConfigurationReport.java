package smart.home.util;

import smart.home.model.*;

public class HouseConfigurationReport extends Report{
    @Override
    protected String prepareReportContent() {
        House house = House.getHouse();
        StringBuilder reportBuilder = new StringBuilder();

        reportBuilder.append("House Configuration Report\n");

        // Animals
        reportBuilder.append("Animals:\n");
        for (Animal animal : house.getAnimals()) {
            reportBuilder.append(animal.getName()).append("\n");
        }

        // People
        reportBuilder.append("\nPeople:\n");
        for (Person person : house.getPeople()) {
            reportBuilder.append(person.getName()).append("\n");
        }

        // Floors and Rooms
        reportBuilder.append("\nHouse Floors and Rooms:\n");
        for (Floor floor : house.getFloors()) {
            reportBuilder.append("Floor ").append(floor.getLevel()).append(":\n");
            for (Room room : floor.getRooms()) {
                reportBuilder.append("\t").append(room.getName()).append(": ");
                if (room.getDevices() != null) {
                    for (Device device : room.getDevices()) {
                        reportBuilder.append(device.getName(device)).append(", ");
                    }
                    reportBuilder.delete(reportBuilder.length() - 2, reportBuilder.length()).append("\n");
                }
            }
        }

        // Items
        reportBuilder.append("\nItems:\n");
        for (Item item : house.getItems()) {
            reportBuilder.append(item.toString()).append("\n");
        }

        return reportBuilder.toString();
    }
    }
