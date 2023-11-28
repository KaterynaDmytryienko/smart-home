package smart.home.model;

import smart.home.event.Observer;

public interface Sensor extends Observer {
    public void reactToEvent();
}
