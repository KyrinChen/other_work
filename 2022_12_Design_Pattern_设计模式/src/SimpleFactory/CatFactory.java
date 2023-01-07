package SimpleFactory;

import State.StateCommon;

public class CatFactory {
    public Cat createCat(String breed, String ancestry) {
        CatIngredientFactory catIngredientFactory = new CatIngredientFactory();
        Cat cat = new Cat();
        cat.setCatBreed(catIngredientFactory.setBreed(breed));
        cat.setCatAncestry(catIngredientFactory.setAncestry(ancestry));
        cat.setCatName(ancestry + breed);
        if (cat.getCatBreed().getBreed() == "中华田园猫") {
            cat.setSpeed(106);
            cat.setIntelligence(96);
            cat.setBeauty(94);
            cat.setSkill(104);
        } else if (cat.getCatBreed().getBreed() == "布偶猫") {
            cat.setSpeed(103);
            cat.setIntelligence(99);
            cat.setBeauty(100);
            cat.setSkill(101);
        } else if (cat.getCatBreed().getBreed() == "加菲猫") {
            cat.setSpeed(98);
            cat.setIntelligence(104);
            cat.setBeauty(99);
            cat.setSkill(108);
        }

        if (ancestry == "血统级") {
            cat.setSpeed(Math.round(cat.getSpeed()* 1.1)) ;
            cat.setIntelligence(Math.round(cat.getIntelligence()*1.1));
            cat.setBeauty(Math.round(cat.getBeauty()*1.1));
            cat.setSkill(Math.round(cat.getSkill()* 1.1));
        } else if (ancestry == "赛级") {
            cat.setSpeed(Math.round(cat.getSpeed()* 1.2)) ;
            cat.setIntelligence(Math.round(cat.getIntelligence()*1.2));
            cat.setBeauty(Math.round(cat.getBeauty()*1.2));
            cat.setSkill(Math.round(cat.getSkill()* 1.2));
        }
        cat.setRank(new int[]{0, 0, 0});
        cat.setScore(new double[]{0, 0, 0});
        cat.setCatState(new StateCommon());
        return cat;
    }
}
