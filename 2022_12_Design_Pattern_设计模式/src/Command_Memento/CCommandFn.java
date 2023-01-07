package Command_Memento;

import Adapter.AliAdapter;
import Adapter.WechatPay;
import Decorator.Food;
import Interpreter.ExchangePrice;
import Interpreter.OriginalPrice;
import Interpreter.Price;

import java.util.Scanner;

public class CCommandFn {
    //单例模式
    //执行猫猫喂食控制台交互的类
    private static CCommandFn instance = new CCommandFn();

    private CCommandFn() {
    }

    public static CCommandFn getInstance() {
        return instance;
    }

    public boolean CommandFn() throws InterruptedException {

        System.out.println("\n请选择您要投喂的食品:");
        System.out.println("[0]退出 [1]肉食 [2]饼干 [3]饮用水:");
        int i;
        Scanner scan_input = new Scanner(System.in);
        i = scan_input.nextInt();
        boolean isFed = false;  //判断是否投喂成功
        while (true) {
            if (i == 0) break;
            switch (i) {
                case 1: {
                    //投喂肉食
                    CareTaker foodList = new CareTaker();
                    Command feedMeat = new FeedMeatCommand();
                    feedMeat.execute();
                    Food myMeat = feedMeat.getMyFood();
                    foodList.append(feedMeat, myMeat.createMemento());
                    FeedCondiment meatCondiment = new FeedCondiment(foodList, myMeat);
                    isFed = meatCondiment.start();
                    System.out.println(isFed);
                    break;
                }
                case 2: {
                    //投喂饼干
                    CareTaker foodList = new CareTaker();
                    Command feedCookies = new FeedCookiesCommand();
                    feedCookies.execute();
                    Food myCookies = feedCookies.getMyFood();
                    foodList.append(feedCookies, myCookies.createMemento());
                    FeedCondiment cookiesCondiment = new FeedCondiment(foodList, myCookies);
                    isFed = cookiesCondiment.start();
                    break;
                }
                case 3: {
                    //投喂饮用水
                    CareTaker foodList = new CareTaker();
                    Command feedWater = new FeedWaterCommand();
                    feedWater.execute();
                    Food myWater = feedWater.getMyFood();
                    foodList.append(feedWater, myWater.createMemento());
                    FeedCondiment waterCondiment = new FeedCondiment(foodList, myWater);
                    isFed = waterCondiment.start();
                    break;
                }
                default:
                    break;
            }
            i = 0;
            if (!isFed) {
                System.out.println("\n请选择您要投喂的食品:");
                System.out.println("[0]退出 [1]肉食 [2]饼干 [3]饮用水:");
                i = scan_input.nextInt();
            }
        }
        //如果投喂成功，则进行支付
        if (isFed) {
            Price price = new Price();
            price.SetOriPrice(100f);
            System.out.println("您的点单原价为100");
            price.SetExchange(10f);
            System.out.println("目前汇率 —— 1:10");
            OriginalPrice oriPriceInterpreter = new OriginalPrice();
            oriPriceInterpreter.Method(price);
            float result;
            ExchangePrice discountPriceInterpreter = new ExchangePrice();
            result = discountPriceInterpreter.Method(price);
            System.out.println("现价为：" + result);
            Scanner scan = new Scanner(System.in);
            int type;
            System.out.println("请选择你要使用的支付方式：\n1、支付宝支付  2、微信支付");
            type = scan.nextInt();
            switch (type) {
                case 1: {
                    //使用支付宝
                    new AliAdapter().pay();
                    break;
                }
                case 2: {
                    //使用微信
                    new WechatPay().pay();
                    break;
                }
            }
            return true;
        }
        return false;
    }
}

