import processing.core.PImage;

public class CustomPanel extends Panel {

    public CustomPanel (int _x, int _y, int _w, int _h){
        super(_x,_y,_w,_h);
    }

    public void display(){
        PImage newImg2 = getImage().copy();
        newImg2.loadPixels();
        for (int x = 0; x<newImg2.width; x++) {
            for (int y = 0; y <newImg2.height; y++) {
                int loc = x+y*newImg2.width;
                if (Main.app.alpha(newImg2.pixels[loc]) > 0){
                    float r = Main.app.red(newImg2.pixels[loc]);
                    float g = Main.app.green(newImg2.pixels[loc]);
                    float b = Main.app.blue(newImg2.pixels[loc]);
                    newImg2.pixels[loc] = Main.app.color(b,r,g*2);
                }
            }
        }
        newImg2.updatePixels();
        Main.app.image (newImg2, getX(), getY(), getWidth(), getHeight());
    }
}