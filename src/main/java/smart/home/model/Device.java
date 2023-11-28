package smart.home.model;

import smart.home.event.Observer;
import smart.home.util.Documentation;
import smart.home.util.DocumentationLoader;

public abstract class Device implements Observer {
    private Documentation documentation;

    public Device() {
        this.documentation = null;
    }


    public Documentation getDocumentation(){
        if(documentation==null){
            documentation=DocumentationLoader.loadDocumentation(this);
        }
        return documentation;
    }
}
