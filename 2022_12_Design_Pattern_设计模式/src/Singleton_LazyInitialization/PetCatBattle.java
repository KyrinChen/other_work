package Singleton_LazyInitialization;

import Builder.Game;
import Builder.GamesBuilder;
import Command_Memento.CCommandFn;
import Composite.Menu;
import Composite.MenuOption;
import Facade.Facade;
import Filter.AndCriteria;
import Filter.CompetitionLevelCriteria;
import Filter.Criteria;
import Filter.RagDollCatCriteria;
import Iterator.CatContainer;
import Iterator.GameContainer;
import Mediator.CMediatorFn;
import Prototpye_Flyweight.CPrototypeFn;
import Proxy.ProxyScoreSheet;
import Proxy.ScoreSheet;
import Servant.Preparation;
import Servant.Worker;
import SimpleFactory.Cat;
import SimpleFactory.CatFactory;


import java.util.ArrayList;
import Bridge.*;
import FactoryMethod.*;
import State.StateCommon;
import State.StatePerfect;
import State.StateTired;
import Template_Strategy.HandcraftComp;
import Template_Strategy.PageantComp;
import Template_Strategy.QuizComp;
import Template_Strategy.RaceComp;
import Visitor.CVisitorFn;
import java.util.Scanner;

public class PetCatBattle {
    private Cat petCat;
    public boolean Emergency=false;

    //养成资金暂时放这里，不知道后续调用是否方便
    private int money;

    //让构造函数为 private，这样该类就不会被实例化
    private PetCatBattle() {
    }

    //实例化函数
    public static PetCatBattle getInstance() {
        return SingletonHolder.instance;
    }

    //用于测试
    public void showMessage() {
        System.out.println("PetCatBattle System Created Successfully!");
    }

    //用于控制系统的流程
    public void systemController() throws CloneNotSupportedException {
        System.out.println("欢迎来到猫猫养成大比拼系统！你一开始拥有10000猫猫币，合理规划资产，养成最棒的猫猫吧！");
        Scanner input = new Scanner(System.in);

        //创建宠物猫猫
        System.out.println("给你要养的猫猫起个名字吧：");
        String name = input.nextLine();
        System.out.println("选择你的物种 [1]中华田园猫 [2]布偶猫 [3]加菲猫");
        int breedNum = input.nextInt();
        System.out.println("选择你的宠物血统等级 [1]宠物级（免费！） [2]血统级（3000猫猫币） [3]赛级（5000猫猫币）");
        int ancestryNum = input.nextInt();

        String breed = "";
        String ancestry = "";
        switch (breedNum) {
            //不同品种的猫基础属性不同
            case 1:
                breed = "中华田园猫";
                break;
            case 2:
                breed = "布偶猫";
                break;
            case 3:
                breed = "加菲猫";
                break;
            default:
                break;
        }
        switch (ancestryNum) {
            //不同等级的猫猫有基础属性加成，宠物级*1，血统级*1.1,赛级*1.2
            case 1:
                ancestry = "宠物级";
                money = 10000;
                break;
            case 2:
                ancestry = "血统级";
                money = 7000;
                break;
            case 3:
                ancestry = "赛级";
                money = 5000;
                break;
            default:
                break;
        }

        //调用简单工厂，快速生成猫猫实例
        CatFactory catFactory = new CatFactory();
        petCat = catFactory.createCat(breed, ancestry);
        petCat.setCatName(name);
        CatContainer.getInstance().add(petCat);
        //构建其他对手猫猫(暂时还没构建)
        CatContainer.getInstance().add(catFactory.createCat("中华田园猫", "血统级"));
        CatContainer.getInstance().add(catFactory.createCat("布偶猫", "宠物级"));
        CatContainer.getInstance().add(catFactory.createCat("加菲猫", "赛级"));
        CatContainer.getInstance().add(catFactory.createCat("中华田园猫", "血统级"));
        CatContainer.getInstance().add(catFactory.createCat("布偶猫", "宠物级"));
        CatContainer.getInstance().add(catFactory.createCat("中华田园猫", "宠物级"));
        CatContainer.getInstance().add(catFactory.createCat("加菲猫", "血统级"));
        CatContainer.getInstance().add(catFactory.createCat("布偶猫", "赛级"));
        CatContainer.getInstance().add(catFactory.createCat("中华田园猫", "赛级"));
        CatContainer.getInstance().add(catFactory.createCat("加菲猫", "血统级"));
        //构建比赛项目
        GamesBuilder.getInstance().buildGames();
        for (Game game : GameContainer.getInstance().getGames()) {
            game.showGameInfo();
        }
        //检录
        Facade facade = new Facade();
        facade.method();
        //比赛正式开始
        Menu rootMenu = new Menu("大厅选择");
        //第一个比赛菜单
        Menu gameMenu = new Menu("比赛");
        int element = 0;
        MenuOption speed_race = new MenuOption("竞速比赛", GameContainer.getInstance().get(0));
        MenuOption beauty_race = new MenuOption("选美比赛", GameContainer.getInstance().get(1));
        MenuOption intelligence_race = new MenuOption("智力比赛", GameContainer.getInstance().get(2));
        MenuOption skill_race = new MenuOption("技术比赛", GameContainer.getInstance().get(3));

        gameMenu.add(speed_race);
        gameMenu.add(beauty_race);
        gameMenu.add(intelligence_race);
        gameMenu.add(skill_race);
        MenuOption drinkTable = new MenuOption("猫猫喂食区", CCommandFn.getInstance());
        MenuOption queryRank = new MenuOption("询问比赛成绩", element);
        MenuOption buyEquipment = new MenuOption("购买猫猫神装", element);
        MenuOption printRank = new MenuOption("打印成绩单", element);
        MenuOption meetAudience = new MenuOption("猫猫友好会晤", element);
        rootMenu.add(gameMenu);
        rootMenu.add(drinkTable);
        rootMenu.add(queryRank);
        rootMenu.add(buyEquipment);
        rootMenu.add(printRank);
        rootMenu.add(meetAudience);
        // 菜单以及选择返回
        rootMenu.printMenu();
        System.out.println("目前猫猫币剩余："+money);
        System.out.println("猫猫的心情状态是："+petCat.getCatState().toString());
        int i = input.nextInt();
        int gameVisited = 0;
        while (i != 0) {
            switch (i) {
                case 1: {//比赛
                    gameMenu.printMenu();
                    Game game;
                    switch (input.nextInt()) {
                        case 1:
                            game = (RaceComp) (gameMenu.getMenu().get(0).option);
                            if (game.isVisited()) {
                                System.out.println("该项目已结束，请参加其他项目！");
                                break;
                            }
                            Worker worker1 = new Worker();
                            worker1.prepare((Preparation) game);
                            game.gameStart();
                            game.gameEnd();
                            ++gameVisited;
                            break;
                        case 2:
                            game = (PageantComp) (gameMenu.getMenu().get(1).option);
                            if (game.isVisited()) {
                                System.out.println("该项目已结束，请参加其他项目！");
                                break;
                            }
                            Worker worker2 = new Worker();
                            worker2.prepare((Preparation) game);
                            game.gameStart();
                            game.gameEnd();
                            ++gameVisited;
                            break;
                        case 3:
                            game = (QuizComp) (gameMenu.getMenu().get(2).option);
                            if (game.isVisited()) {
                                System.out.println("该项目已结束，请参加其他项目！");
                                break;
                            }
                            Worker worker3 = new Worker();
                            worker3.prepare((Preparation) game);
                            game.gameStart();
                            game.gameEnd();
                            ++gameVisited;
                            break;
                        case 4:
                            game = (HandcraftComp) (gameMenu.getMenu().get(3).option);
                            if (game.isVisited()) {
                                System.out.println("该项目已结束，请参加其他项目！");
                                break;
                            }
                            game.gameStart();
                            game.gameEnd();
                            ++gameVisited;
                            break;
                        case 0:
                            speed_race.getLast().printMenu();
                            i = input.nextInt();
                            break;
                        default:
                            break;
                    }
                    System.out.println("猫猫参加完比赛有点累，状态下降！");
                    if (gameVisited == 4) {
                        System.out.println("");
                    }
                    break;
                }
                case 2:
                    CCommandFn CCommandFn = (CCommandFn) rootMenu.getMenu().get(1).option;
                    boolean isDrink = false;
                    try {
                        isDrink = CCommandFn.CommandFn();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(isDrink){
                        System.out.println("在猫猫喂食区休息了一会儿，状态提升！");
                        money-=1000;
                        switch (petCat.getCatState().toString()) {
                            case "StatePerfect":
                                break;
                            case "StateCommon":
                                petCat.setCatState(new StatePerfect());
                                break;
                            case "StateTired":
                                petCat.setCatState(new StateCommon());
                                break;
                            default:
                                break;
                        }
                        CMediatorFn.getInstance().MediateFn();
                    }
                    break;
                //查看比赛成绩（查看粉丝数、人气值等）
                case 3://询问成绩
                    System.out.println("输入要询问的猫猫编号：");
                    int n = input.nextInt() - 1;
                    //待修改
                    System.out.println("选择要询问的比赛 [1]竞速比赛 [2]选美比赛 [3]智力比赛 [4]技术比赛");
                    int m = input.nextInt();
                    Game game = GameContainer.getInstance().get(m - 1);
                    if (!game.isVisited()) {
                        System.out.println("该比赛尚未开始！");
                        break;
                    }
                    CVisitorFn.VisitorFn(n, game);
                    break;
                case 4://购买装备
                   System.out.println("欢迎光临运动装备专卖店！");
                   System.out.println("选购心仪的装备 [1]博士眼镜 [2]讲究围巾");
                   int k = input.nextInt();
                   if (k == 1) {
                        System.out.println(petCat.getCatName()+"原来的美貌值是："+petCat.getBeauty());
                        System.out.println(petCat.getCatName()+"原来的智力值是："+petCat.getIntelligence());
                        GlassesFactory glassesFactory = new GlassesFactory();
                        Equipment glasses = glassesFactory.createEquipment(petCat);
                        EquipmentImplementor ei = new PerfectEquip();
                        AbstractCatEquip equipment = new GlassesEquipment(ei);
                        equipment.EquipEquipment(petCat, glasses);
                        System.out.println(petCat.getCatName()+"现在的美貌值是："+petCat.getBeauty());
                        System.out.println(petCat.getCatName()+"现在的智力值是："+petCat.getIntelligence());
                        money-=1000;
                   } else if (k == 2) {
                        System.out.println(petCat.getCatName()+"原来的速度值是："+petCat.getSpeed());
                        System.out.println(petCat.getCatName()+"原来的技巧值是："+petCat.getSkill());
                        ScarfFactory scarfFactory = new ScarfFactory();
                        Equipment scarf = scarfFactory.createEquipment(petCat);
                        EquipmentImplementor ei = new PerfectEquip();
                        AbstractCatEquip equipment = new ScarfEquipment(ei);
                        equipment.EquipEquipment(petCat, scarf);
                        System.out.println(petCat.getCatName()+"原来的速度值是："+petCat.getSpeed());
                        System.out.println(petCat.getCatName()+"原来的技巧值是："+petCat.getSkill());
                       money-=1000;
                   }

                   System.out.println();
                    break;
                case 5:
                    ScoreSheet proxyScoreSheet = new ProxyScoreSheet();
                    proxyScoreSheet.printScoreSheet();
                    break;
                case 6:
                    try {
                        CPrototypeFn.PrototypeFn();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                case 0:
                    break;
                default:
                    break;
            }
            if (gameVisited == 4) {
                System.out.println("所有比赛均已结束！");
                break;
            }

            if(gameVisited==2 && Emergency ==false){
                Emergency =true;
                //Filter 如下
                Criteria ragDollCriteria = new RagDollCatCriteria();
                Criteria competitionLevelCriteria = new CompetitionLevelCriteria();
                System.out.println("铛铛铛！出现突发事件！有猫猫质检员要来进行血统筛查！他要给每只赛级布偶猫3000猫猫币！");
                System.out.println("输入任意数字+回车以继续");
                int opt = input.nextInt();
                System.out.println("\n ----- 血统筛选之前: ----- ");
                for (Cat cat : CatContainer.getInstance().getCats()) {
                    System.out.println(cat.getCatAncestry().getAncestry() + cat.getCatBreed().getBreed() + ":" + cat.getCatName());
                }
                AndCriteria andCriteria = new AndCriteria(ragDollCriteria, competitionLevelCriteria);
                ArrayList<Cat> filterList = andCriteria.meetCriteria(CatContainer.getInstance().getCats());
                System.out.println("\n ----- 经过筛查(赛级布偶猫): ----- ");
                for (Cat cat : filterList) {
                    System.out.println(cat.getCatAncestry().getAncestry() + cat.getCatBreed().getBreed() + ":" + cat.getCatName());
                    if (petCat.getCatName()==cat.getCatName()){
                        System.out.println("你获得了3000猫猫币！恭喜恭喜！");
                        money+=3000;
                    }
                }
            }

            rootMenu.printMenu();
            System.out.println("目前猫猫币剩余："+money);
            System.out.println("猫猫的心情状态是："+petCat.getCatState().toString());
            i = input.nextInt();
        }
        System.out.println("养成比拼到此结束！感谢你的参与");
    }
    private static class SingletonHolder {
        // 静态初始化器，有JVM来保证线程安全
        private static PetCatBattle instance = new PetCatBattle();
    }
}
