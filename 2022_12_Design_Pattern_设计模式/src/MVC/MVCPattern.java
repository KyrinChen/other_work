package MVC;

import SimpleFactory.Cat;
import SimpleFactory.CatFactory;

import java.util.Scanner;

public class MVCPattern {
    public static void main(String[] args) {
        Cat model = getCat();

        CatViews views = new CatViews();

        CatController controller = new CatController(model,views);

        controller.updateView();

        String str;
        System.out.println("plz input new name:");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        controller.setCatName(str);

        controller.updateView();
    }

    private static Cat getCat(){
        return new CatFactory().createCat("中华田园猫", "Green");
    }
}
