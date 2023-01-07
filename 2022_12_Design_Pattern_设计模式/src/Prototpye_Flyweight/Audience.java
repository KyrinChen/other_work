package Prototpye_Flyweight;
//  @program: AnimalGame
//  @description: 粉丝见面会
//  @author: zxa
//  @create: 2022/12/17

public abstract class Audience implements Cloneable {

    public String color;    //Color of Audience
    protected String type;
    protected String sex;      //Sex of Audience
    protected int age;      //Age of Audience
    protected String race;  //Race of Audience
    private String id;

    protected abstract void printRace();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRace() {
        return race;
    }

    //对象复制
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
