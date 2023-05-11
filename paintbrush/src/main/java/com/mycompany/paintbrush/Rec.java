
package com.mycompany.paintbrush;


import javax.naming.AuthenticationNotSupportedException;
import java.awt.*;

public class Rec extends AllShapes{
    Point start;
    int width;
    int height;
    boolean filled;

    public Rec (Dimension Size) throws AuthenticationNotSupportedException {
        throw new AuthenticationNotSupportedException("Not Supported yet");
    }

    public Rec(){}

    public Rec(Point start, int width, int height, Color sColor){
        super (sColor);
        this.start=start;
        this.width=width;
        this.height=height;
    }
    public Rec(Point start, int width, int height){
        this.start=start;
        this.width=width;
        this.height=height;
    }

    public Rec(Point start, int width, int height, Color sColor, boolean dotted, boolean filled){
        super (sColor);
        this.start=start;
        this.width=width;
        this.height=height;
        this.dotted=dotted;
        this.filled =filled;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
