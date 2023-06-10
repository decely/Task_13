package com.example.task_13;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Element extends Component{

    @Override

    public void add(Component component) throws ComponentException {

        throw new ComponentException();

    }


    public Element() {

        prefix=new Character('-');

        name=new String("varname");

        type=new String("typevar");

        x=0;

        y=0;

        w=200;

        h=25;

        style="-fx-background-color: darkslateblue; -fx-text-fill: black; -fx-border-insets: 3; -fx-border-width: 1; -fx-border-style: solid;";

    }


    @Override

    public  void remove(Component component) throws ComponentException {

        throw new ComponentException();

    }

    @Override

    public  Component getChild(int index) throws ComponentException {

        throw new ComponentException();

    }



    @Override

    public void draw(Pane pane) {

        Label field = (Label) getPicture();// для отображения

        field.setPrefSize((w), (h));

        field.setLayoutX(x);

        field.setLayoutY(y);

        pane.getChildren().add(field);

    }

    @Override

    public Node getPicture() {

        String text=new String(prefix.toString());

        text+=" "+name+" "+type;

        Label field = new Label(text);

        field.setStyle(style);

        return field;

    }


    public void setX(double x) {

        this.x = x;

    }

    @Override
    public void setY(double y) {

        this.y = y;

    }

    @Override
    public void setW(double w) {

    }

    @Override
    public void setH(double h) {
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getW() {
        return w;
    }

    @Override
    public double getH() {
        return h;
    }


    @Override
    public void setText(char curPrefix, String curName, String curType) {
        prefix = curPrefix;
        name = curName;
        type = curType;
    }

    @Override
    public String getText() {
        String fullName = name + type;
        return fullName;
    }

    @Override
    public void setColor(String color) {
        style = "-fx-background-color: "+color+"; -fx-text-fill: black; -fx-border-insets: 3; -fx-border-width: 1; -fx-border-style: solid;";
    }


}
