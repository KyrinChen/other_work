package FactoryMethod;

import SimpleFactory.Cat;

public class GlassesFactory implements IFactory {
    //创建眼镜
    @Override
    public Equipment createEquipment(Cat owner) {
        return new Glasses(owner);
    }
}
