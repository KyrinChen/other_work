package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Cat;

public abstract class AbstractCatEquip {
    private EquipmentImplementor CatEquip;

    public AbstractCatEquip(EquipmentImplementor CatEquip) {
        this.CatEquip = CatEquip;
    }

    public void EquipEquipment(Cat Cat, Equipment equipment) {
        this.CatEquip.equip(Cat, equipment);
    }
}
