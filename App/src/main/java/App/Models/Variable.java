package App.Models;

import javafx.scene.control.CheckBox;

public class Variable {
    String name;
    CheckBox checkBox = new CheckBox();
    public Variable(String name) {
        this.name = name;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
