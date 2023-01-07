package Builder;

import AbstractFactory.Judge;
import AbstractFactory.JudgeStore;
import Iterator.CatContainer;
import Iterator.JudgeContainer;
import SimpleFactory.Cat;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    private String name;
    private List<Cat> catLists = new ArrayList<Cat>();
    private Judge judge;
    private double[] score = new double[8];
    private int[] rankByNO = new int[8];
    private int[] rankByRank = new int[8];
    private boolean isVisited;

    public Game(String Name) {
        name = Name;
        switch (Name) {
            case "竞速比赛":
                judge = JudgeStore.getInstance().orderJudge("Race");
                judge.setJudgeName("裁判猫猫-竞速组");
                break;
                
            case "选美比赛":
                judge = JudgeStore.getInstance().orderJudge("Pageant");
                judge.setJudgeName("裁判猫猫-选美组");
                break;

            case "智力比赛":
                judge = JudgeStore.getInstance().orderJudge("Quiz");
                judge.setJudgeName("裁判猫猫-智力组");
                break;
            case "技术比赛":
                judge = JudgeStore.getInstance().orderJudge("Handcraft");
                judge.setJudgeName("裁判猫猫-技术组");
                break;
            default:
                break;
        }
        JudgeContainer.getInstance().add(judge);
        for (int i = 0; i < 8; ++i) {
            addCat(CatContainer.getInstance().get(i));
        }
        isVisited = false;
    }

    //getter & setter
    public void addCat(Cat cat ) {
        catLists.add(cat);
    }

    public abstract void gameStart();

    public abstract void gameEnd();

    public abstract void getValue(int no);

    public String getName() {
        return name;
    }

    public List<Cat> getCatLists() {
        return catLists;
    }

    public Judge getJudge() {
        return judge;
    }

    public double[] getScore() {
        return score;
    }

    public int[] getRankByNO() {
        return rankByNO;
    }

    public int[] getRankByRank() {
        return rankByRank;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
    //排名
    public void sortScore() {
        for (int i = 0; i < 8; ++i) {
            rankByNO[i] = 1;
        }
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (score[i] < score[j]) {
                    ++rankByNO[j];
                }
            }
        }
        for (int i = 0; i < 8; ++i) {
            rankByRank[rankByNO[i] - 1] = i;
        }
    }

    //输出测试信息
    public void showGameInfo() {
        System.out.println("比赛名称：" + name);
        System.out.println("参赛猫猫名单：");
        for (int i = 1; i <= 8; ++i) {
            System.out.println("参赛编号：" + i + "  姓名：" + catLists.get(i - 1).getCatName());
        }
        if (judge != null) {
            System.out.println("本场裁判：" + judge.getJudgeName());
        }
    }

}
