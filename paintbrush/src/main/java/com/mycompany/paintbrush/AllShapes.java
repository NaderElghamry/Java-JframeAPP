package com.mycompany.paintbrush;

import java.awt.*;

public class AllShapes {

    protected Color sColor;
    boolean dotted;

    public AllShapes() {
    }

    public AllShapes(Color sColor, boolean dotted) {
        this.sColor = sColor;
        this.dotted = dotted;
    }

    public AllShapes(Color sColor) {
        this.sColor = sColor;
    }

    public Color getsColor() {
        return sColor;
    }

    public void setsColor(Color sColor) {
        this.sColor = sColor;
    }

    public boolean isDotted() {
        return dotted;
    }

    public void setDotted(boolean dotted) {
        this.dotted = dotted;
    }
}
