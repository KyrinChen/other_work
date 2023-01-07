package Prototpye_Flyweight;
//  @program: AnimalGame
//  @description: 粉丝见面会
//  @author: zxa
//  @create: 2022/12/17

public class Audience_ChCountryCat extends Audience {

    public Audience_ChCountryCat() {
        race = "中华田园猫";
    }

    public Audience_ChCountryCat(String color) {
        this.color = color;
    }

    @Override
    public void printRace() {
        System.out.println("这只中华田园猫的颜色为：" + color + ", 年龄为:" + age + ", 性别为:" + sex);
    }
}
