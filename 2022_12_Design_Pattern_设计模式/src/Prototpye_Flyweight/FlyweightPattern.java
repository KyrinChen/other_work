package Prototpye_Flyweight;

import java.util.Scanner;

//  @program: AnimalGame
//  @description: 粉丝见面会
//  @author: zxa
//  @create: 2022/12/17

public class FlyweightPattern {
    private static final String color[] =
            {"Black", "White", "Yellow", "Brown", "Gray"};

    public static void main(String[] args) {
        System.out.println("请输入猫猫的种类");
        System.out.println("\"1\":中华田园猫 \"2\":加菲猫 \"3\":布偶猫");
        System.out.println("输入\"view\"来查看数量！");
        System.out.println("输入\"detail\"查看观众详情!");
        System.out.println("输入\"Q\"退出");
        int counter = 0;
        int ChCountryCatCounter = 0;
        int[] ChCountryCatsCounter = new int[5];
        int GarfieldCounter = 0;
        int[] GarfieldsCounter = new int[5];
        int RagdollCounter = 0;
        int[] RagdollsCounter = new int[5];
        String str = "";
        boolean flag = true;
        while (flag) {
            Scanner sc = new Scanner(System.in);
            str = sc.nextLine();
            switch (str) {
                case "1": {
                    String color = getRandomColor();
                    if (color == "Black") {
                        ChCountryCatsCounter[0]++;
                    } else if (color == "White") {
                        ChCountryCatsCounter[1]++;
                    } else if (color == "Yellow") {
                        ChCountryCatsCounter[2]++;
                    } else if (color == "Brown") {
                        ChCountryCatsCounter[3]++;
                    } else if (color == "Gray") {
                        ChCountryCatsCounter[4]++;
                    }
                    Audience_ChCountryCat chCountryCatAudience = (Audience_ChCountryCat) AttributeFactory.setChCountryCatAudience(color);
                    chCountryCatAudience.setAge(getRandomAge());
                    chCountryCatAudience.setSex(getRandomSex());
                    chCountryCatAudience.printRace();
                    ChCountryCatCounter++;
                    counter++;
                }
                ;
                break;
                case "2": {
                    String color = getRandomColor();
                    if (color == "Black") {
                        GarfieldsCounter[0]++;
                    } else if (color == "White") {
                        GarfieldsCounter[1]++;
                    } else if (color == "Yellow") {
                        GarfieldsCounter[2]++;
                    } else if (color == "Brown") {
                        GarfieldsCounter[3]++;
                    } else if (color == "Gray") {
                        GarfieldsCounter[4]++;
                    }
                    Audience_Garfield garfieldAudience = (Audience_Garfield) AttributeFactory.setGarfieldAudience(color);
                    garfieldAudience.setAge(getRandomAge());
                    garfieldAudience.setSex(getRandomSex());
                    garfieldAudience.printRace();
                    GarfieldCounter++;
                    counter++;
                }
                ;
                break;
                case "3": {
                    String color = getRandomColor();
                    if (color == "Black") {
                        RagdollsCounter[0]++;
                    } else if (color == "White") {
                        RagdollsCounter[1]++;
                    } else if (color == "Yellow") {
                        RagdollsCounter[2]++;
                    } else if (color == "Brown") {
                        RagdollsCounter[3]++;
                    } else if (color == "Gray") {
                        RagdollsCounter[4]++;
                    }
                    Audience_Ragdoll bearAudience = (Audience_Ragdoll) AttributeFactory.setRagdollAudience(color);
                    bearAudience.setAge(getRandomAge());
                    bearAudience.setSex(getRandomSex());
                    bearAudience.printRace();
                    RagdollCounter++;
                    counter++;
                }
                ;
                break;
                case "detail": {
                    System.out.println("Black中华田园猫:" + ChCountryCatsCounter[0] + ", White中华田园猫:" + ChCountryCatsCounter[1] +
                            ", Yellow中华田园猫:" + ChCountryCatsCounter[2] + ", Brown中华田园猫:" + ChCountryCatsCounter[3] + ", Gray中华田园猫:" + ChCountryCatsCounter[4]);
                    System.out.println("Black加菲猫:" + GarfieldsCounter[0] + ", White加菲猫:" + GarfieldsCounter[1] +
                            ", Yellow加菲猫:" + GarfieldsCounter[2] + ", Brown加菲猫:" + GarfieldsCounter[3] + ", Gray加菲猫:" + GarfieldsCounter[4]);
                    System.out.println("Black布偶猫:" + RagdollsCounter[0] + ", White布偶猫:" + RagdollsCounter[1] +
                            ", Yellow布偶猫:" + RagdollsCounter[2] + ", Brown布偶猫:" + RagdollsCounter[3] + ", Gray布偶猫:" + RagdollsCounter[4]);
                }
                ;
                break;
                case "view": {
                    System.out.println("观众数量:" + counter);
                    System.out.println("中华田园猫数量:" + ChCountryCatCounter);
                    System.out.println("加菲猫数量:" + GarfieldCounter);
                    System.out.println("布偶猫数量:" + RagdollCounter);
                }
                ;
                break;
                case "Q": {
                    flag = false;
                }
                ;
                break;
                default: {
                    System.out.println("输入无效，请重试!");
                }
                ;
                break;
            }
        }
    }

    public static String getRandomColor() {
        return color[(int) (Math.random() * color.length)];
    }

    public static int getRandomAge() {
        int maxAge = 60;
        int minAge = 1;
        return minAge + (int) (Math.random() * maxAge);
    }

    public static String getRandomSex() {
        if (((Math.random() * 100) % 2) == 1) {
            return "MALE";
        } else {
            return "FEMALE";
        }
    }
}
