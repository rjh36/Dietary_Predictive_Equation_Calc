/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dietary_predictive_equation_calc;

import Predicitve_Equations.Predictive_Equations;
import Predictive_Equations.Interfaces.IPredictive_Equations;
import javafx.application.Application;
import javafx.event.ActionEvent;
import static javafx.geometry.Pos.TOP_CENTER;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Robert
 */
public class Dietary_Predictive_Equation_Calc extends Application {
    
    /**
     *
     */
    public static final int ELEMENTS_IN_VBOX = 10;
    public static final int DEFAULT_SPACING = 10;
    public static final int WINDOW_WIDTH = 300;
    public static final int WINDOW_HEIGHT = 400;
    
    @Override
    public void start(Stage stage) {
        showInputs(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void addResult(VBox layout, String equationName, Double result) {
        Label equation_Name = new Label(equationName);
        Label equation_Result = new Label(result.toString());
        HBox hbEquation = new HBox(DEFAULT_SPACING);
        hbEquation.getChildren().addAll(equation_Name, equation_Result);
        
        layout.getChildren().add(hbEquation);
    }
    
    public void showInputs(Stage stage) {
    // Creates the vertical pane to hold the input controls.
        VBox layout = new VBox(DEFAULT_SPACING);
        layout.setAlignment(TOP_CENTER);
        layout.setStyle("-fx-padding: 20 0 0 0;");
        
    // Age input section.
        TextField age = new TextField ();
        layout.getChildren().addAll(new Label("Age:"), age);
        
    // Weight input section.
    // Kilograms!!!
        TextField weight = new TextField ();
        layout.getChildren().addAll(new Label("Weight:"), weight);
        
    // Height input section.
    // Centimeters!!!
        TextField height = new TextField ();
        layout.getChildren().addAll(new Label("Height:"), height);
        
    // Gender input section.
        final ToggleGroup genderGroup = new ToggleGroup();
        RadioButton male = new RadioButton("Male");
        male.setToggleGroup(genderGroup);
        male.setSelected(true);
        RadioButton female = new RadioButton("Female");
        female.setToggleGroup(genderGroup);
        layout.getChildren().addAll(new Label("Gender:"), male, female);
        
    // Trauma input section
        CheckBox trauma = new CheckBox("Trauma?");
        layout.getChildren().add(trauma);
        
    // Burns input section
        CheckBox burns = new CheckBox("Burns?");
        layout.getChildren().add(burns);
        
    // Ventilator input section
        CheckBox ventilator = new CheckBox("Ventilator?");
        layout.getChildren().add(ventilator);
        
    // RespRate input section.
        TextField respRate = new TextField ();
        layout.getChildren().addAll(new Label("RespRate:"), respRate);
        
    // TidalVolume input section.
        TextField tidalVolume = new TextField ();
        layout.getChildren().addAll(new Label("TidalVolume:"), tidalVolume);
        
    // HeartRate input section.
        TextField heartRate = new TextField ();
        layout.getChildren().addAll(new Label("HeartRate:"), heartRate);
        
    // Tmax input section.
        TextField Tmax = new TextField ();
        layout.getChildren().addAll(new Label("Tmax:"), Tmax);
        
    // Ve input section.
        TextField Ve = new TextField ();
        layout.getChildren().addAll(new Label("Ve:"), Ve);
        
    // Calculation button, tells the application to mainScreenReturn the values.
        Button calculate = new Button();
        calculate.setText("Calculate responses.");
        calculate.setOnAction((ActionEvent event) -> {
            try {
                Patient patient = new Patient(age.getText(),
                        weight.getText(),
                        height.getText(),
                        male.isSelected(),
                        trauma.isSelected(),
                        burns.isSelected(),
                        respRate.getText(),
                        tidalVolume.getText(),
                        heartRate.getText(),
                        Tmax.getText(),
                        Ve.getText());
                
                showResults(stage, patient, ventilator.isSelected());
            }
            catch(IllegalArgumentException e) {
                if(layout.getChildren().size() > ELEMENTS_IN_VBOX)
                    layout.getChildren().remove(ELEMENTS_IN_VBOX);
                Label error = new Label(e.getMessage());
                error.setTextFill(Color.RED);
                layout.getChildren().add(error);
            }
        });
        layout.getChildren().add(calculate);
        
        Scene scene = new Scene(layout, WINDOW_WIDTH, WINDOW_HEIGHT);
        
        stage.setTitle("Dietary Predictive Equation Calculator!");
        stage.setScene(scene);
        stage.show();
    }
    
    public void showResults(Stage stage, Patient patient, boolean ventilator) {
    // Creates the vertical pane to hold the input results.
        VBox layout = new VBox(DEFAULT_SPACING);
        layout.setAlignment(TOP_CENTER);
        layout.setStyle("-fx-padding: 20 0 0 0;");
        
    // Calculates and shows the results of the predictive equations.
        IPredictive_Equations pe = new Predictive_Equations();// CHANGE.
        
        
        addResult(layout, "HarrisBenedict:", pe.HarrisBenedict(patient));
        addResult(layout, "MifflinStJeor:", pe.MifflinStJeor(patient));
        addResult(layout, "IretonJones1992:", pe.IretonJones1992(patient));
        addResult(layout, "IretonJones1997:", pe.IretonJones1997(patient));
        if(ventilator) {
            addResult(layout, "PennState1998:", pe.PennState1998(patient));
            addResult(layout, "PennState2003:", pe.PennState2003(patient));
            addResult(layout, "PennState2010:", pe.PennState2010(patient));
            addResult(layout, "Swinamer1990:", pe.Swinamer1990(patient));
            addResult(layout, "Brandi1999:", pe.Brandi1999(patient));
            addResult(layout, "Faisy2003:", pe.Faisy2003(patient));
        }
        
    // Calculation button, tells the application to mainScreenReturn the values.
        Button mainScreenReturn = new Button();
        mainScreenReturn.setText("Input responses.");
        mainScreenReturn.setOnAction((ActionEvent event) -> {
        // Method call to show previous scene.
            showInputs(stage);
        });
        layout.getChildren().add(mainScreenReturn);
        
    // Shows the scene.
        Scene scene = new Scene(layout, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Dietary Predictive Equation Results!");
        stage.setScene(scene);
        stage.show();
    }
}