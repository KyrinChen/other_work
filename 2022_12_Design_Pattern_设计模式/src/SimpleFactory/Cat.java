package SimpleFactory;

import State.CatState;

public class Cat {
    private String catName;
    private Breed catBreed;
    private Ancestry catAncestry;
    private double beauty;
    private double intelligence;
    private double speed;
    private double skill;
    private CatState catState;
    private int[] Rank;
    private double[] Score;

    public Cat() {
    }

    //构造函数（不会调用，仅作为比较）
    private Cat(Breed breed, Ancestry ancestry) {
        catBreed = breed;
        catAncestry = ancestry;
        catName = catAncestry.getAncestry() + catBreed.getBreed();
        if (catBreed.getBreed() == "中华田园猫") {
            speed = 106;
            intelligence = 96;
            beauty = 94;
            skill = 104;
        } else if (catBreed.getBreed() == "布偶猫") {
            speed = 103;
            intelligence = 99;
            beauty = 100;
            skill = 101;
        } else if (catBreed.getBreed() == "加菲猫") {
            speed = 98;
            intelligence = 104;
            beauty = 99;
            skill = 108;
        }
    }

    //getter & stter
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getBeauty() {
        return beauty;
    }

    public void setBeauty(double beauty) {
        this.beauty = beauty;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String newName) {
        catName = newName;
    }

    public Breed getCatBreed() {
        return catBreed;
    }

    public void setCatBreed(Breed newBreed) {
        catBreed = newBreed;
    }

    public Ancestry getCatAncestry() {
        return catAncestry;
    }

    public void setCatAncestry(Ancestry newAncestry) {
        catAncestry = newAncestry;
    }

    public int[] getRank() {
        return Rank;
    }

    public void setRank(int[] rank) {
        Rank = rank;
    }

    public double[] getScore() {
        return Score;
    }

    public void setScore(double[] score) {
        Score = score;
    }

    public CatState getCatState() {
        return catState;
    }

    public void setCatState(CatState newState) {
        this.catState = newState;
    }

    //输出测试信息
    public void showCatInfo() {
        System.out.println("Name is " + catName + "!");
        catBreed.getBreed();
        catAncestry.getAncestry();
    }
}
