package TransferObject;

import SimpleFactory.Cat;
import SimpleFactory.CatFactory;

import java.util.ArrayList;
import java.util.List;

public class CatBO {
    List<Cat> cats;

    public CatBO() {
        cats = new ArrayList<>();
        Cat cat1 = new CatFactory().createCat("加菲猫", "宠物级");
        Cat cat2 = new CatFactory().createCat("布偶猫", "赛级");
        Cat cat3 = new CatFactory().createCat("中华田园猫", "血统级");
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
    }

    //删除动物
    public void deleteCat(Cat cat) {
        cats.remove(cat);
        System.out.println(cat.getCatName() + "已经离开了!");
    }

    //getter
    public List<Cat> getAllCats() {
        return cats;
    }

    public Cat getCat(int rollNo) {
        return cats.get(rollNo);
    }

    //更新动物列表
    public void updateCat(Cat cat) {
        cats.add(cat);
        System.out.println(cat.getCatName() + ", 加入了运动会!");
    }
}