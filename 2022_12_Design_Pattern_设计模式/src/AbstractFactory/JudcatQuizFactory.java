package AbstractFactory;

public class JudcatQuizFactory implements JudgeIngredientFactory {
    //吹罚测验
    @Override

    public Breed CreateBreed() {
        return new Judcat();
    }

    @Override
    public GameClass CreateClass() {

        return new CompQuiz();
    }
}
