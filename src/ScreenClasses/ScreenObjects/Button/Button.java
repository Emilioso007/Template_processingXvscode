package ScreenClasses.ScreenObjects.Button;

import LogicClasses.Shapes.AABB;
import ScreenClasses.ScreenManager;
import Utils.Color;
import Utils.MH;
import processing.core.PApplet;
import processing.core.PConstants;

public class Button extends AABB {

    private PApplet p;

    public ButtonAction action;

    public boolean isClicked = false, isHeld = false;
    private boolean isHovered = false;
    private boolean a = false, b = true;

    private Color idleColor, hoveColor, clickColor, currentColor;

    public String text;

    public boolean render = true;

    public Button(int x, int y, int w, int h, String text, ButtonAction action) {
        super(x, y, w, h);
        this.p = ScreenManager.p;
        this.text = text;
        this.action = action;
        idleColor = new Color(255, 0, 0);
        hoveColor = new Color(0, 0, 200);
        clickColor = new Color(0, 200, 0);
        currentColor = idleColor;
    }

    public void update() {
        b = !a;

        if (this.contains(MH.mouseX, MH.mouseY)) {
            isHovered = true;
        } else {
            isHovered = false;
        }

        if (isHovered && MH.leftPressed) {
            isHeld = true;
            a = true;
        } else {
            isHeld = false;
            a = false;
        }

        if (a && b) {
            isClicked = true;
        } else {
            isClicked = false;
        }

        if (isClicked) {
            action.run();
        }

        if (isHeld) {
            currentColor = Color.lerp(currentColor, clickColor, 0.5f);
        } else if (isHovered) {
            currentColor = Color.lerp(currentColor, hoveColor, 0.2f);
        } else {
            currentColor = Color.lerp(currentColor, idleColor, 0.2f);
        }

    }

    public void render() {
        if (!render) {
            return;
        }


        p.stroke(0);
        p.fill(currentColor.c);

        p.rectMode(PConstants.CORNER);
        p.rect(x, y, w, h);

        p.fill(255);
        p.textSize(32);
        p.textAlign(PConstants.LEFT, PConstants.TOP);
        p.text(text, x + w / 2 - p.textWidth(text) / 2, y + h / 2 - p.textAscent() / 2);
    }

}
