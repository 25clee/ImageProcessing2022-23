import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    //client
    //AT Java note: implementation of PApplet (setup, draw, etc) is overriding methods defined in PApplet

    final int NUM_PANELS_HORIZONTAL = 5; //horizontal quantity of panels
    final int NUM_PANELS_VERTICAL = 5; // vertical quantity of panels

    private ArrayList<Panel> panels;
    public static PApplet app; //to always get access to PApplet reference

    public Main(){ //constructor so we can assign a reference to "this object" to app
        super();
        app = this;
    }

    public static void main(String[] args){ //entry point: what gets everything started
        PApplet.main("Main");
    }
    public void setup() {
        panels = new ArrayList<Panel>();
        int h = height/NUM_PANELS_VERTICAL;
        int w = width/NUM_PANELS_HORIZONTAL;
        int index = 0;
        Panel p; //declare Panel variable p
        for (int i = 0; i<NUM_PANELS_VERTICAL; i++){
            int y = i*h;
            for (int j = 0; j<NUM_PANELS_HORIZONTAL; j++){
                int x = j*w;
                if (i==0){
                    p = new Panel(x,y,w,h); //instantiate
                } else if (i ==1) {
                    p = new TintedPanel (x,y,w,h); //polymorphism - can be other subtypes of Panel too because p is of type Panel
                } else if (i==2) {
                    p = new CustomPanel (x,y,w,h);
                } else if (i==3) {
                    p = new RotatingPanel(x,y,w,h);
                } else {
                    p = new ContrastedPanel (x,y,w,h);
                }
                p.setupImage("data/Hoho.png"); //set up its image
                panels.add(p); //add it to the end of arrayList
                index++;
            }
        }
    }

    public void settings(){
        size(600,600);
    }
    public void draw(){
        fancyBackground();
        for (Panel p : panels) {
            p.display();
        }
    }

    public void mouseClicked(){
        for (Panel p : panels){
            p.handleMouseClicked(mouseX, mouseY);
        }
    }

    private void fancyBackground() {
        loadPixels();
        for (int y = 0; y<height;y++){
            for (int x = 0; x<width; x++) {
                int loc = x+y*width;
                pixels[loc] = color (random(82), random(214) , random(247));
            }
        }
        updatePixels();
    }

    public void keyPressed() {
        if (key == 's') {
            Panel firstPanel = panels.remove(0);
            Panel lastPanel = panels.remove(panels.size()-1);
            panels.add(0, lastPanel);
            panels.add(firstPanel);
        }
    }
}