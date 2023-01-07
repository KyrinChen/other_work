package AbstractFactory;

public class Judge {
    /*   软件包指定种类和吹罚比赛，名字在game设置    */
    private String JudgeName;

    private Breed JudgeBreed;
    private  GameClass gameClass;


    private JudgeIngredientFactory factory;

    //getter & setter
    public JudgeIngredientFactory getFactory() {
        return factory;
    }

    public void setFactory(JudgeIngredientFactory factory) {//bind product factory
        this.factory = factory;
    }

    public String getJudgeName() {
        return JudgeName;
    }

    public void setJudgeName(String judgeName) {
        JudgeName = judgeName;
    }


    public  GameClass getGameClass() {
        return gameClass;
    }

    public Breed getJudgeBreed() {
        return JudgeBreed;
    }

    public void setJudgeBreed(Breed judgeBreed) {
        JudgeBreed = judgeBreed;
    }

    public void setGameClass( GameClass gameClass) {
        this.gameClass = gameClass;

    }
}
