public class RotatingPanel extends Panel {

    private float degrees; //maintain state of rotation
    private boolean rotating;

    public RotatingPanel (int _x, int _y, int _w, int _h) {
        super(_x,_y,_w,_h); //first line must be super
        degrees = 1;
        rotating = false;
    }

    public void display(){
        if (!rotating) {
            super.display();
        } else {
            Main.app.push(); //saving old coordinate system
            Main.app.imageMode(Main.app.CENTER); //the x and y passed now become the center point instead of point in top left corner
            int x = getX();
            int y = getY();
            Main.app.translate (x+getWidth()/2, y+getHeight()/2); //center point of Panel object (image) and translated to that point
            Main.app.rotate(Main.app.radians(degrees));
            degrees+=5;
            setX(0); //translating to point where we translated coordinate system to
            setY(0);
            super.display();
            setX(x);
            setY(y);
            Main.app.imageMode(Main.app.CORNER); //so other Panels aren't messed up
            Main.app.pop(); //restore old coordinate system
        }
    }

    public void handleMouseClicked (int mX, int mY) {
        if (mX>getX() && mX<(getX()+getWidth()) && mY>getY() && mY<(getY()+ getHeight())) {
            rotating = !rotating;
        }
    }
}