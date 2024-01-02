# Project Navigation

## Functional Requirements

### F1 - smart.home.model

### F2 - smart.home.controller
- **DeviceAPI:** Method `performActionByState(T device)`
- **SmartHouseAPI:** Method `updatePerformance()`
    - Public method `startSimulation(EventGenerator eventGenerator)` randomly calls the `performActionByState` method, which decreases the performance of the device.

### F3 - smart.home.model
- LightDevice, Multicooker, PetFeeder, etc.

### F4 - smart.home.controller
- **DeviceAPII**

### F5 - smart.home.activity
- AnimalActivity, PersonActivity

### F6 - smart.home.event
- **EventGenerator**

### F7 - smart.home.event
- AnimalHandler, DeviceHandler, PersonHandler

### F8 - smart.home.util
- ActivityAndUsageReport, ConsumptionReport, HouseConfigurationReport, EventReport

### F9 - smart.home.model
- **Device:** `downgradePerformance()` method that decreases the functionality of the device
- smart.home.activity: PersonActivity method `fixDevice()`

### F10 - smart.home.event
- **EventGenerator:** Method `generateEvent()`
- smart.home.activity: PersonActivity, method, e.g., `eat()`
- **PersonHandler:** Method `handleEvent()`

## House Configuration
- **smart.home.util:** HouseConfig

## Tests
- **test/java**

## Design Patterns

- **Factory/Factory Method:** `activity.Activity`
- **Singleton:** `model.House`
- **Observer:** `event.Observer` (used in `DeviceHandler`)
- **Chain of Responsibility:** `event.EventHandler`
- **Partially Persistent Data Structure:** `model.Device` maintains a history of changes to the `consumptionHistory` list (added in `recordConsumption()`)
- **Lazy Initialization:** `model.Device` `getDocumentation()`
- **Template:** `util.Report`