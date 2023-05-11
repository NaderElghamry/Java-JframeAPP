package com.mycompany.paintbrush;

import javax.naming.AuthenticationNotSupportedException;
import java.awt.*;

public class Line extends AllShapes {

    Point start;
    Point p1, p2;
    int width;
    int height;
    boolean filled;

    public Line(Point Size, Point p21, Color color, boolean dotted1) throws AuthenticationNotSupportedException {
        throw new AuthenticationNotSupportedException("Not Supported yet");
    }

    public Line(Point p1, Point p2, Color color, boolean isDotted) {
    }

    public Line(Point start, int width, int height, Color sColor) {
        super(sColor);
        this.start = start;
        this.width = width;
        this.height = height;
    }

    public Line(Point start, int width, int height) {
        this.start = start;
        this.width = width;
        this.height = height;
    }

    public Line(Point start, int width, int height, Color sColor, boolean dotted, boolean filled) {
        super(sColor);
        this.start = start;
        this.width = width;
        this.height = height;
        this.dotted = dotted;
        this.filled = filled;
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

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
}
