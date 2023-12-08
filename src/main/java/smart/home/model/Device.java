package smart.home.model;

import smart.home.event.Observer;
import smart.home.util.Documentation;
import smart.home.util.DocumentationLoader;

public abstract class Device implements Observer {
    private Documentation documentation;
    private int currentConsumption = 0;
    private int activeConsumption = 0;
    private int passiveConsumption = 0;
    private int idleConsumption = 0;

    public Device() {
        this.documentation = null;
    }


    public Documentation getDocumentation(){
        if(documentation==null){
            documentation=DocumentationLoader.loadDocumentation(this);
        }
        return documentation;
    }

    public int getCurrentConsumption() {
        return currentConsumption;
    }

    public void setCurrentConsumption(int currentConsumption) {
        this.currentConsumption = currentConsumption;
    }

    public int getActiveConsumption() {
        return activeConsumption;
    }

    public void setActiveConsumption(int activeConsumption) {
        this.activeConsumption = activeConsumption;
    }

    public int getPassiveConsumption() {
        return passiveConsumption;
    }

    public void setPassiveConsumption(int passiveConsumption) {
        this.passiveConsumption = passiveConsumption;
    }

    public int getIdleConsumption() {
        return idleConsumption;
    }

    public void setIdleConsumption(int idleConsumption) {
        this.idleConsumption = idleConsumption;
    }
}
