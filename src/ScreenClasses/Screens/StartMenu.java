package ScreenClasses.Screens;

import ScreenClasses.Screen;
import ScreenClasses.ScreenManager;
import ScreenClasses.ScreenObjects.Button.Button;
import ScreenClasses.ScreenObjects.Button.ButtonHandler;
import ScreenClasses.ScreenObjects.Slider.Slider;
import ScreenClasses.ScreenObjects.Slider.SliderHandler;
import processing.core.PApplet;

public class StartMenu extends Screen {

    private PApplet p;
    private ButtonHandler buttonHandler;
    private SliderHandler sliderHandler;

    public StartMenu() {
        p = ScreenManager.p;

        buttonHandler = new ButtonHandler();

        buttonHandler.addButton(
            new Button(p.width / 2 - 100, p.height / 2 - 50, 200, 100, "StartButton", () -> {
            System.out.println("StartButton pressed");
        }));

        buttonHandler.addButton(
            new Button(p.width / 2 - 100, p.height / 2 + 100, 200, 100, "ExitButton", () -> {
            System.out.println("ExitButton pressed");
        }));

        sliderHandler = new SliderHandler();

        sliderHandler.addSlider(new Slider(100, 100, 100, 20, "Slider", 0.5f));
    }

    public void update() {

        buttonHandler.update();
        sliderHandler.update();

    }

    public void render() {
        p.background(42);

        buttonHandler.render();
        sliderHandler.render();
    }

}
