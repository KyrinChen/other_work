package FactoryMethod;

import SimpleFactory.Cat;

public abstract class Equipment {
    Cat Owner;

    public Equipment(Cat owner) {
        Owner = owner;
    }

    public abstract void function();
    //Equipment abstract class as super class

    public abstract String getEquipmentName();
}
