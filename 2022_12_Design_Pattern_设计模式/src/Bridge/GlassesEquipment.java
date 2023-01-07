package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Cat;

public class GlassesEquipment extends AbstractCatEquip {
    public GlassesEquipment(EquipmentImplementor CatEquip) {
        super(CatEquip);
    }

    //桥接后增加新的功能
    @Override
    public void EquipEquipment(Cat Cat, Equipment equipment) {
        super.EquipEquipment(Cat, equipment);
        Cat.setIntelligence(Cat.getIntelligence() + 3);
        Cat.setBeauty(Cat.getBeauty() + 2);
    }
}
