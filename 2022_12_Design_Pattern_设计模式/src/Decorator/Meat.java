package Decorator;

import Command_Memento.Memento;

public class Meat extends Food {
    //肉食类（被装饰者）

    @Override
    public String getDescription() {
        return "肉食" + condiment;
    }

    public Memento createMemento() {
        return new Memento(this.condiment);
    }

}
