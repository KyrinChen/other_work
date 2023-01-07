package FrontController;

public class Dispatcher {
    private JudgeView judgeView;
    private CatView catView;

    public Dispatcher() {
        judgeView = new JudgeView();
        catView = new CatView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("JUDGE")) {
            judgeView.show();
        } else {
            catView.show();
        }
    }
}
