import processing.core.PImage;

public class Panel {

    //instance variables
    private int x;
    private int y;
    private int w;
    private int h;
    private PImage img;

    //constructor
    public Panel (int _x, int _y, int _w, int _h){
        x = _x;
        y = _y;
        w = _w;
        h = _h;
    }

    //3 instance methods
    public void setupImage(String imageName) {
        img = Main.app.loadImage(imageName);
    }

    public void display (){
        Main.app.image (img, x, y, w, h);
    }

    public void handleMouseClicked (int mX, int mY) {
        if (mX>x && mX<(x+w) && mY>y && mY<(y+h)) {
            System.out.println ("mouse clicked");
        }
    }

    public PImage getImage() { //getter for the image instance variable (since img is private, cannot access it in ContrastedPanel)
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX (int _x){
        x = _x;
    }

    public void setY (int _y){
        y = _y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }
}