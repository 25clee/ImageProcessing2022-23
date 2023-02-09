public class TintedPanel extends Panel {

    public TintedPanel (int _x, int _y, int _w, int _h){
        super(_x,_y,_w,_h); //invoke Panel constructor
    }

    public void display(){
        Main.app.tint(255,0,0,200);
        super.display(); //invoking Panel version of display
        Main.app.noTint();
    }

}