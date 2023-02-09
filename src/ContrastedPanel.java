import processing.core.PImage;
public class ContrastedPanel extends Panel {

    public ContrastedPanel (int _x, int _y, int _w, int _h){
        super(_x,_y,_w,_h); //invoke Panel constructor
    }

    public void display(){
        PImage newImg = getImage().copy();
        newImg.loadPixels();
        for (int y = 0; y < newImg.height; y++){ //row
            for (int x = 0; x < newImg.width; x++){ //columns
                int loc = x+(y*newImg.width);
                if (Main.app.brightness(newImg.pixels[loc]) > 190){
                    newImg.pixels[loc] = Main.app.color(255);
                } else {
                    newImg.pixels[loc] = Main.app.color(0,0);
                }
            }
        }
        newImg.updatePixels();
        Main.app.image (newImg, getX(), getY(), getWidth(), getHeight());
    }

}