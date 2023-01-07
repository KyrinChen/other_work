package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Cat;

public class ScarfEquipment extends AbstractCatEquip {
    public ScarfEquipment(EquipmentImplementor CatEquip) {
        super(CatEquip);
    }

    //桥接后增加新的功能
    @Override
    public void EquipEquipment(Cat Cat, Equipment equipment) {
        super.EquipEquipment(Cat, equipment);
        Cat.setSpeed(Cat.getSpeed() + 3);
        Cat.setSkill(Cat.getSkill() + 2);
    }

}
