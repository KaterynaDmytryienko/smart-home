package smart.home.util;

import smart.home.model.*;

public class HouseConfigurationReport extends Report{
    @Override
    protected String prepareReportContent() {
        House house = House.getHouse();
        StringBuilder reportBuilder = new StringBuilder();

        reportBuilder.append("House Configuration Report\n");

        // Animals
        reportBuilder.append("\nAnimals:\n\n");
        for (Animal animal : house.getAnimals()) {
            reportBuilder.append(animal.getName()).append(",\t");
        }

        // People
        reportBuilder.append("\nPeople:\n");
        for (Person person : house.getPeople()) {
            reportBuilder.append(person.getName()).append(",\t");
        }

        // Floors and Rooms
        reportBuilder.append("\n\nHouse Floors and Rooms:\n");
        for (Floor floor : house.getFloors()) {
            reportBuilder.append("Floor ").append(floor.getLevel()).append(":\n");
            for (Room room : floor.getRooms()) {
                reportBuilder.append("\n\t").append(room.getName());
                if (room.getDevices() != null) {
                    reportBuilder.append(":\n\t\tDevices: ");
                    for (Device device : room.getDevices()) {
                        reportBuilder.append(device.getName(device)).append(", ");
                    }
                    reportBuilder.delete(reportBuilder.length() - 2, reportBuilder.length()).append("\n");
                }
            }
        }

        // Items
        reportBuilder.append("\n\nItems:\n\t");
        for (Item item : house.getItems()) {
            reportBuilder.append(item.getType()).append("\n");
        }

        return reportBuilder.toString();
    }
    }
