package Template_Strategy;

import Builder.Game;
import Observer.ScoreSubject;
import Servant.Preparation;
import SimpleFactory.Cat;
import State.StateCommon;
import State.StatePerfect;
import State.StateTired;

import java.util.Random;

public class PageantComp extends Game implements Preparation {
    public PageantComp(String Name) {
        super(Name);
    }

    @Override
    public void gamePreparation() {
        System.out.println("选美大赛即将开始！");

        try {  //sleep必须处理异常
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("选手入场完毕！");
    }

    @Override
    public void gameStart() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("选美大赛开始！");
        for (int i = 0; i < 8; ++i) {
            getValue(i);
        }
        sortScore();
    }

    @Override
    public void gameEnd() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("选美大赛结束!最终成绩：");
        setVisited(true);
        for (int i = 1; i <= 8; ++i) {
            System.out.println("参赛猫猫号码：" + i + "  名字：" + getCatLists().get(i - 1).getCatName() + "  评分：" + String.format("%.2f",getScore()[i - 1]) + "分");
        }
        System.out.println("第一名：" + getCatLists().get(getRankByRank()[7]).getCatName());
        System.out.println("第二名：" + getCatLists().get(getRankByRank()[6]).getCatName());
        System.out.println("第三名：" + getCatLists().get(getRankByRank()[5]).getCatName());
        System.out.println("你的名次：" +  (9-getRankByNO()[0]));
        ScoreSubject.getInstance().notifyObserver(1, getRankByNO(), getScore());
        if (getRankByNO()[0] >= 6) {
            switch (getCatLists().get(0).getCatState().toString()) {
                case "StatePerfect":
                    getCatLists().get(0).setCatState(new StateCommon());
                    break;
                case "StateCommon":
                    getCatLists().get(0).setCatState(new StateTired());
                    break;
                case "StateTired":
                    break;
                default:
                    break;
            }
        } else if (getRankByNO()[0] == 1) {
            switch (getCatLists().get(0).getCatState().toString()) {
                case "StatePerfect":
                    break;
                case "StateCommon":
                    getCatLists().get(0).setCatState(new StatePerfect());
                    break;
                case "StateTired":
                    getCatLists().get(0).setCatState(new StateCommon());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void getValue(int no) {
        Random rand = new Random();
        double random = (rand.nextInt(2000) + 9000);
        Cat athlete = getCatLists().get(no);
        double value = (athlete.getSpeed() * 1 + athlete.getBeauty() * 1.4 + athlete.getIntelligence() * 1 + athlete.getSkill() * 1) * athlete.getCatState().getState();
        double time = value * 0.5623183 * random / 10000;
        getScore()[no] = time;
    }


}
