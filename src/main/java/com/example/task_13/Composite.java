package com.example.task_13;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Composite extends Component{
    ArrayList<Component> array=new ArrayList<>();// агрегатор элементарных объектов


    public Composite(ArrayList<Component> array) {// может быть реализован и с другим набором параметров

        this.array = array;

    }


    @Override

    public void add(Component component) throws ComponentException {

        array.add(component);

    }

    @Override
    public void remove(Component component) throws ComponentException {

    }

    @Override
    public Component getChild(int index) throws ComponentException {
        return null;
    }



    @Override
    public Node getPicture() {
        return null;
    }


    @Override

    public void draw(Pane pane) {

        if (array.isEmpty()) return;

        for (Component comp: array) comp.draw(pane);

    }


    @Override

    public void setX(double x) {

        if (array.isEmpty()) return;

        for (Component comp: array) comp.setX(x);

    }

    @Override
    public void setY(double y) {

        if (array.isEmpty()) return;

        for (Component comp: array) {
            comp.setY(y + array.indexOf(comp)*24);
        }

    }

    @Override
    public void setW(double w) {

    }

    @Override
    public void setH(double h) {

    }

    @Override
    public double getX() {
        if (array.isEmpty()) return 0;
        double x = 0;
        for (Component comp: array){
            x = comp.getX();
            break;
        }
        return x;
    }

    @Override
    public double getY() {
        if (array.isEmpty()) return 0;
        double y = 0;
        for (Component comp: array){
            y = comp.getY();
            break;
        }
        return y;
    }

    @Override
    public double getW() {
        if (array.isEmpty()) return 0;
        double w = 0;
        for (Component comp: array){
            w = comp.getW();
            break;
        }
        return w;
    }

    @Override
    public double getH() {
        if (array.isEmpty()) return 0;
        double h = 0;
        for (Component comp: array){
            h = comp.getH();
            break;
        }
        return h;
    }

    @Override
    public void setText(char prefix, String name, String type) {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void setColor(String color) {
        if (array.isEmpty()) return;

        for (Component comp: array) comp.setColor(color);
    }

}
