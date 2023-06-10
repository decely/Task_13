package com.example.task_13;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class Component {
    // описание поля класса

    Character prefix;

    String name;

    String type;

    // параметры рисования

    protected double x;

    protected double y;

    protected double w;

    protected double h;

    protected String style;

    // методы общие для Element и Composite, реализованные по-разному

    public abstract void add (Component component) throws ComponentException;

    public abstract void remove (Component component) throws ComponentException;

    public abstract Component getChild (int index) throws ComponentException;

    public abstract void draw(Pane pane);

    public abstract Node getPicture();

    public abstract void setX(double x);

    public abstract void setY(double y);

    public abstract void setW(double w);

    public abstract void setH(double h);

    public abstract double getX();

    public abstract double getY();

    public abstract double getW();

    public abstract double getH();
    public abstract void setText(char prefix, String name, String type);
    public abstract String getText();
    public abstract void setColor(String color);
}
