package MVC;

import SimpleFactory.Cat;

public class CatController {
    private Cat model;
    private CatViews view;

    public CatController(Cat model, CatViews views) {
        this.model = model;
        this.view = views;
    }

    public void setCatName(String name){
        model.setCatName(name);
    }

    public String getCatName(){
        return model.getCatName();
    }

    public void updateView(){
        view.printCatDetails(model.getCatName());
    }
}
