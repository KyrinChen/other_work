package Proxy;

import Builder.Game;
import Iterator.GameContainer;

public class RealScoreSheet implements ScoreSheet {
    @Override
    //打印成绩单
    public void printScoreSheet() {
        for (int i = 0; i < 4; ++i) {
            switch (i) {
                case 0:
                    System.out.println("竞速比赛最终结果：");
                    break;
                case 1:
                    System.out.println("选美比赛最终结果：");
                    break;
                case 2:
                    System.out.println("智力比赛最终结果：");
                    break;
                case 3:
                    System.out.println("技术比赛最终结果：");
                    break;
                default:
                    break;
            }
            if (GameContainer.getInstance().get(i).isVisited()) {
                Game game = GameContainer.getInstance().get(i);
                if ( i == 0)
                    for (int j = 1; j <= 8; ++j) {
                        System.out.println("参赛编号：" + j + "  姓名：" + game.getCatLists().get(j - 1).getCatName()
                                + "  成绩：" + game.getScore()[j - 1] + "秒");
                }
                else
                    for (int j = 1; j <= 8; ++j) {
                        System.out.println("参赛编号：" + j + "  姓名：" + game.getCatLists().get(j - 1).getCatName()
                                + "  评分：" + game.getScore()[j - 1] + "分");
                    }
            }
        }
    }
}
