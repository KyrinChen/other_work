package Facade;

import Iterator.CatContainer;

public class Exam {
    //体检
    public void dosomething() {
        System.out.println("猫猫体检...");
        System.out.println("你的猫猫名字是：" + CatContainer.getInstance().get(0).getCatName());
        System.out.println("你的猫猫品种是：" + CatContainer.getInstance().get(0).getCatBreed().getBreed());
        System.out.println("你的猫猫等级是：" + CatContainer.getInstance().get(0).getCatAncestry().getAncestry());
        System.out.println("你的猫猫智力值是：" + CatContainer.getInstance().get(0).getIntelligence());
        System.out.println("你的猫猫速度值是：" + CatContainer.getInstance().get(0).getSpeed());
        System.out.println("你的猫猫美貌值是：" + CatContainer.getInstance().get(0).getBeauty());
        System.out.println("你的技巧能力值：" + CatContainer.getInstance().get(0).getSkill());
    }
}
