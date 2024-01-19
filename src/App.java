//test1

import ScreenClasses.ScreenManager;
import ScreenClasses.Screens.StartMenu;
import Utils.KH;
import Utils.MH;
import processing.core.*;
import processing.event.MouseEvent;

public class App extends PApplet {

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void settings() {
        size(1280, 720, P2D);
        smooth(8);
    }

    public void setup() {
        KH.initialize();
        MH.initialize(this);
        ScreenManager.initialize(this);
        ScreenManager.setScreen(new StartMenu());
    }

    public void draw() {
        MH.update();

        ScreenManager.run();

        showFPS();
    }

    private void showFPS() {
        fill(255);
        textSize(16);
        textAlign(RIGHT, TOP);
        text("FPS: " + nfc(frameRate, 1), width-5, 0);
    }

    public void keyPressed() {
        KH.keyPressed(keyCode);
    }

    public void keyReleased() {
        KH.keyReleased(keyCode);
    }

    public void mouseWheel(MouseEvent event) {
        MH.mouseWheel(event.getCount(), frameCount);
    }

}