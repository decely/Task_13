package com.example.task_13;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public ComboBox comboBox;
    public Pane pane;
    public ColorPicker colorPicker;
    public CheckBox checkBox;
    public CheckBox editCheck;
    public Label curEditLabel;
    public TextField textField;
    private String selectedVariant = "";
    private int currentDrag = -1;
    private int currentElement = -1;
    private boolean addMode = false;
    private boolean editMode = false;
    ArrayList<Composite> compositeList = new ArrayList<>();
    ArrayList<Element> elementList = new ArrayList<>();


    public void onSelectComboBox(ActionEvent actionEvent) {
        String selectedValue = comboBox.getValue().toString();
        System.out.println("Selected " + selectedValue);
        switch (selectedValue){
            case "Вариант А":
                selectedVariant = "A";
                break;
            case "Вариант Б":
                selectedVariant = "B";
                break;
            case "Вариант В":
                selectedVariant = "C";
                break;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(FXCollections.observableArrayList("Вариант А","Вариант Б", "Вариант В"));
    }

    public void onPaneClicked(MouseEvent mouseEvent) throws ComponentException {
        if (addMode) {
            System.out.println("Pane Clicked");
            ArrayList<Component> componentList = new ArrayList<>();
            Composite composite = new Composite(componentList);
            double x = mouseEvent.getX();
            double y = mouseEvent.getY();
            boolean failed = false;
            switch (selectedVariant) {
                case "A":
                    Element elementA1 = new Element();
                    elementA1.setText(' ', "Имя класса", "");
                    composite.add(elementA1);
                    elementList.add(elementA1);
                    break;
                case "B":
                    Element elementB1 = new Element();
                    Element elementB2 = new Element();
                    elementB1.setText(' ', "Имя класса", "");
                    elementB2.setText('-', "Имя атрибута:", "Тип атрибута");
                    composite.add(elementB1);
                    composite.add(elementB2);
                    elementList.add(elementB1);
                    elementList.add(elementB2);
                    break;
                case "C":
                    Element elementC1 = new Element();
                    Element elementC2 = new Element();
                    Element elementC3 = new Element();
                    elementC1.setText(' ', "Имя класса", "");
                    elementC2.setText('-', "Имя атрибута:", "Тип атрибута");
                    elementC3.setText('+', "Имя операции():", "Тип операции");
                    composite.add(elementC1);
                    composite.add(elementC2);
                    composite.add(elementC3);
                    elementList.add(elementC1);
                    elementList.add(elementC2);
                    elementList.add(elementC3);
                    break;
                default:
                    System.out.println("Variant not selected");
                    failed = true;
                    break;
            }
            if (!failed) {
                composite.setX(x);
                composite.setY(y);
                String hex = "#" + Integer.toHexString(colorPicker.getValue().hashCode());
                composite.setColor(hex);
                composite.draw(pane);
                compositeList.add(composite);
                System.out.println("Successfully added");
            }
        }
        else if (editMode) {
            System.out.println("Start edit");
            double curx = mouseEvent.getX();
            double cury = mouseEvent.getY();
            elementList.forEach(element -> {
                double x = element.getX();
                double y = element.getY();
                double w = element.getW();
                double h = element.getH();
                if (x < curx && curx < x + w && y < cury && cury < y + h) {
                    currentElement = elementList.indexOf(element);
                    curEditLabel.setText("Выбран элемент: " + elementList.get(currentElement).getText());
                }
            });
        }
    }

    public void onColorSelected(ActionEvent actionEvent) {
        pane.getChildren().clear();
        String hex = "#" + Integer.toHexString(colorPicker.getValue().hashCode());
        compositeList.forEach(composite -> {
            composite.setColor(hex);
            composite.draw(pane);
        });
        System.out.println("Color change complete");
    }


    public void onMouseDragStart(MouseEvent mouseEvent) {
        if (!addMode && !editMode) {
            System.out.println("Start dragging");
            double curx = mouseEvent.getX();
            double cury = mouseEvent.getY();
            compositeList.forEach(composite -> {
                double x = composite.getX();
                double y = composite.getY();
                double w = composite.getW();
                double h = composite.getH();
                if (x < curx && curx < x + w && y < cury && cury < y + h) {
                    currentDrag = compositeList.indexOf(composite);
                }
            });
        }
    }

    public void onMouseDragEnd(MouseEvent mouseEvent) {
        if (!addMode && !editMode) {
            if (currentDrag != -1) {
                System.out.println("Ending dragging");
                compositeList.get(currentDrag).setX(mouseEvent.getX());
                compositeList.get(currentDrag).setY(mouseEvent.getY());
                pane.getChildren().clear();
                compositeList.forEach(composite -> {
                    composite.draw(pane);
                });
                currentDrag = -1;
            }
            else{
                System.out.println("Nothing to drag");
            }
        }
    }

    public void onAddModeChange(ActionEvent actionEvent) {
        addMode = checkBox.isSelected();
    }

    public void onEditModeChange(ActionEvent actionEvent) {
        editMode = editCheck.isSelected();
    }

    public void onTextFieldEdit(ActionEvent actionEvent) {
        if (currentElement != -1 && editMode){
            elementList.get(currentElement).setText(' ',textField.getText(),"");
            compositeList.forEach(composite -> {
                composite.draw(pane);
            });
        }
    }
}