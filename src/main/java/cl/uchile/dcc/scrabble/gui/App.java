package cl.uchile.dcc.scrabble.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * JavaFX App
 */
public class App extends Application {
    private static final String RESOURCE_PATH = "src/main/resources/";

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Welcome to Scrabble");
        var group = new Group();
        var s_buttons = scrabbleRadioButtons();
        var s_operations = operationsRadioButtons();
        var trig_buttons = buttons();

        // labels
        var variable = new Text("Create a Variable");
        Font font = Font.loadFont(getClass().getResourceAsStream("/fonts/BLACKBOYSONMOPEDS.ttf"), 30);
        variable.setFont(font);
        variable.setFill(Color.ORANGERED);
        variable.setLayoutX(30);
        variable.setLayoutY(40);

        var operation = new Text("Apply an Operation");
        operation.setFont(font);
        operation.setFill(Color.RED);
        operation.setWrappingWidth(170);
        operation.setLayoutX(35);
        operation.setLayoutY(350);

        var result = new Text("Your result is:");
        result.setFont(font);
        result.setFill(Color.BLUEVIOLET);
        //operation.setWrappingWidth(170);
        result.setLayoutX(525);
        result.setLayoutY(350);

        // background
        var background = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "background.png")));
        Scene scene = new Scene(group, 800, 480);

        // input value
        var label1 = new Text("Value:");
        TextField textField = new TextField();
        HBox hb = new HBox();
        hb.setLayoutX(10);
        hb.setLayoutY(210);
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);

        // display result
        var label2 = new Text("");
        TextField textField2 = new TextField();
        HBox hb2 = new HBox();
        hb2.setLayoutX(573);
        hb2.setLayoutY(375);
        hb2.getChildren().addAll(label2, textField2);

        // add background
        group.getChildren().add(background);
        group.getChildren().addAll(variable, operation, result);

        group.getChildren().add(hb);
        group.getChildren().add(hb2);

        // add buttons (creates scrabble types)
        group.getChildren().addAll(s_buttons);

        // add buttons (scrabble operations)
        group.getChildren().addAll(s_operations);

        // add trigger buttons
        group.getChildren().addAll(trig_buttons);
        //group.getChildren().add(scroll);
        subWindow(group);

        stage.setScene(scene);
        stage.show();
    }
    private @NotNull RadioButton[] scrabbleRadioButtons(){
        final ToggleGroup group = new ToggleGroup();
        RadioButton s_int = new RadioButton("Scrabble Int");
        RadioButton s_flt = new RadioButton("Scrabble Float");
        RadioButton s_bin = new RadioButton("Scrabble Binary");
        RadioButton s_str = new RadioButton("Scrabble String");
        RadioButton s_bool = new RadioButton("Scrabble Bool");

        s_int.setLayoutX(60);
        s_flt.setLayoutX(60);
        s_bin.setLayoutX(60);
        s_str.setLayoutX(60);
        s_bool.setLayoutX(60);

        s_int.setLayoutY(70);
        s_flt.setLayoutY(95);
        s_bin.setLayoutY(120);
        s_str.setLayoutY(145);
        s_bool.setLayoutY(170);

        s_int.setToggleGroup(group);
        s_flt.setToggleGroup(group);
        s_bin.setToggleGroup(group);
        s_str.setToggleGroup(group);
        s_bool.setToggleGroup(group);

        RadioButton[] buttons = {s_int, s_flt, s_bin, s_str, s_bool};
        return buttons;
    }

    private @NotNull RadioButton[] operationsRadioButtons(){
        final ToggleGroup group = new ToggleGroup();
        RadioButton toInt = new RadioButton("to Scrabble Int");
        RadioButton toFlt = new RadioButton("to Scrabble Float");
        RadioButton toBin = new RadioButton("to Scrabble Binary");
        RadioButton toStr = new RadioButton("to Scrabble String");
        RadioButton toBool = new RadioButton("to Scrabble Bool");
        RadioButton add = new RadioButton("Addition");
        RadioButton sub = new RadioButton("Subtraction");
        RadioButton div = new RadioButton("Division");
        RadioButton mult = new RadioButton("Multiplication");
        RadioButton and = new RadioButton("Logical And");
        RadioButton or = new RadioButton("Logical Or");
        RadioButton not = new RadioButton("Logical Not");

        toInt.setLayoutX(190);
        toFlt.setLayoutX(190);
        toBin.setLayoutX(190);
        toStr.setLayoutX(190);
        toBool.setLayoutX(190);
        add.setLayoutX(190);
        sub.setLayoutX(350);
        div.setLayoutX(350);
        mult.setLayoutX(350);
        and.setLayoutX(350);
        or.setLayoutX(350);
        not.setLayoutX(350);

        toInt.setLayoutY(300);
        toFlt.setLayoutY(325);
        toBin.setLayoutY(350);
        toStr.setLayoutY(375);
        toBool.setLayoutY(400);
        add.setLayoutY(425);
        sub.setLayoutY(300);
        div.setLayoutY(325);
        mult.setLayoutY(350);
        and.setLayoutY(375);
        or.setLayoutY(400);
        not.setLayoutY(425);

        toInt.setToggleGroup(group);
        toFlt.setToggleGroup(group);
        toBin.setToggleGroup(group);
        toStr.setToggleGroup(group);
        toBool.setToggleGroup(group);
        add.setToggleGroup(group);
        sub.setToggleGroup(group);
        div.setToggleGroup(group);
        mult.setToggleGroup(group);
        and.setToggleGroup(group);
        or.setToggleGroup(group);
        not.setToggleGroup(group);

        RadioButton[] buttons = {toInt, toFlt, toBin, toStr, toBool, add, sub, div, mult, and, or, not};
        return buttons;
    }

    private @NotNull Button[] buttons(){
        Button create = new Button("Create");
        Button apply = new Button("Apply Operation");
        Button clear = new Button("Clear All");
        Button calculate = new Button("Calculate");

        create.setLayoutX(100);
        create.setLayoutY(245);
        apply.setLayoutX(30);
        apply.setLayoutY(400);
        clear.setLayoutX(650+25);
        clear.setLayoutY(425);
        calculate.setLayoutX(530+25);
        calculate.setLayoutY(425);

        Button[] buttons = {create, apply, clear, calculate};
        return buttons;
    }

    private @NotNull void subWindow(@NotNull Group group) throws FileNotFoundException {
        VBox box = new VBox();
        box.setPrefSize(1000, 700);
        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(525, 280);
        scroll.setLayoutX(274);
        var add = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "add.png")));
        var sub = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "sub.png")));
        var arrow = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "arrow.png")));
        add.setFitWidth(50);
        add.setFitHeight(50);
        add.setTranslateX(500);
        add.setTranslateY(5);
        sub.setFitWidth(50);
        sub.setFitHeight(50);
        sub.setTranslateX(550);
        arrow.setFitHeight(50);
        arrow.setFitWidth(50);
        box.getChildren().add(add);
        box.getChildren().add(sub);
        box.getChildren().add(arrow);
        scroll.setContent(box);
        group.getChildren().add(scroll);

    }

    public static void main(String[] args) {
        launch();
    }

}