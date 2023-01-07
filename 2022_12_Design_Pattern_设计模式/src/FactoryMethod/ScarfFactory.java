package FactoryMethod;

import SimpleFactory.Cat;

public class ScarfFactory implements IFactory {
    //创建护腕
    @Override
    public Equipment createEquipment(Cat owner) {
        return new Scarf(owner);
    }
}
