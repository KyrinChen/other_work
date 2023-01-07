package Command_Memento;

import Decorator.Food;

import java.util.Scanner;

public class FeedCondiment {
    //执行添加配料的控制台交互类
    private CareTaker myCare;
    private Food myFood;

    public FeedCondiment(CareTaker myCare, Food myFood) {
        this.myCare = myCare;
        this.myFood = myFood;
    }

    public boolean start() throws InterruptedException {
        System.out.println("\n请选择你需要添加的配料:");
        System.out.println("[0]退出 [1]维生素剂 [2]牛奶 [3]蛋白粉 [4]撤销 [5]重做 [6]确认:");
        int j;
        Scanner scan_input1 = new Scanner(System.in);
        j = scan_input1.nextInt();
        while (j != 0) {
            if (j == 1) {
                //添加维生素
                myCare.clear();
                Command addVitamin = new AddVitaminCommand(myFood);
                addVitamin.execute();
                myCare.append(addVitamin, myFood.createMemento());
                System.out.println("您的当前投喂:" + myFood.getDescription());
            } else if (j == 2) {
                //添加牛奶
                myCare.clear();
                Command addMilk = new AddMilkCommand(myFood);
                addMilk.execute();
                myCare.append(addMilk, myFood.createMemento());
                System.out.println("您的当前投喂: " + myFood.getDescription());
            } else if (j == 3) {
                //添加蛋白粉
                myCare.clear();
                Command addProteinPowder = new AddProteinPowderCommand(myFood);
                addProteinPowder.execute();
                myCare.append(addProteinPowder, myFood.createMemento());
                System.out.println("您的当前投喂: " + myFood.getDescription());
            } else if (j == 4) {
                //undo
                myCare.undo();
                System.out.println("您的当前投喂: " + myFood.getDescription());
            } else if (j == 5) {
                //redo
                myCare.redo();
                System.out.println("您的当前投喂: " + myFood.getDescription());
            } else if (j == 6) {
                //确定喂食
                System.out.println("投喂成功");
                System.out.println("您的最终投喂: " + myFood.getDescription());
                return true;
            }

            System.out.println("\n请选择你需要添加的配料:");
            System.out.println("[0]退出 [1]维生素剂 [2]牛奶 [3]蛋白粉 [4]撤销 [5]重做 [6]确认:");
            j = scan_input1.nextInt();
        }
        return false;
    }
}
