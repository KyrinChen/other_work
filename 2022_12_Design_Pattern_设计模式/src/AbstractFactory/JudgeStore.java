package AbstractFactory;

public class JudgeStore {
    //单例模式
    private static JudgeStore instance = new JudgeStore();
    private JudgeStore() { }
    public static JudgeStore getInstance() {
        return instance;
    }

    //选择对应工厂
    public Judge createJudge(String JudgeName) {

        Judge judge = new Judge();
        JudgeIngredientFactory factory;

        switch (JudgeName) {
            case "Race":
                factory = new JudcatRaceFactory();
                judge.setFactory(factory);
                break;
            case "Pageant":
                factory = new JudcatPageantFactory();
                judge.setFactory(factory);
                break;
            case "Quiz":
                factory = new JudcatQuizFactory();
                judge.setFactory(factory);
                break;
            case "Handcraft":
                factory = new JudcatHandcraftFactory();
                judge.setFactory(factory);
            default:
                break;
        }

        return judge;
    }

    //传入名字 ， 裁判类别和比赛类别自动设置
    public Judge orderJudge(String JudgeName) {
        Judge judge = createJudge(JudgeName);

        judge.setGameClass(judge.getFactory().CreateClass());
        judge.setJudgeBreed(judge.getFactory().CreateBreed());

        return judge;
    }

}
