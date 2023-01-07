package FactoryMethod;

import SimpleFactory.Cat;

public interface IFactory {
    Equipment createEquipment(Cat owner);
}
