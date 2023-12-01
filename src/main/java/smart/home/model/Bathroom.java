package smart.home.model;

public class Bathroom extends Room {
 private FloodSensor floodSensor;

 public Bathroom(){
  super();
  setFloodSensor(new FloodSensor());
 }
 public FloodSensor getFloodSensor() {
  return floodSensor;
 }

 public void setFloodSensor(FloodSensor floodSensor) {
  this.floodSensor = floodSensor;
 }

}
