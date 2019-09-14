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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
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
    public static final int VBOX_SPACING = 10;
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
    
    // Be sure to clean this up later.
    public boolean getGender(ToggleGroup genderGroup, RadioButton male) throws IllegalArgumentException {
        if (genderGroup.getSelectedToggle() != null)
            return male.isSelected();
        else
            throw new IllegalArgumentException("Please select a gender");
    }
    
    public void addResult(VBox layout, String equationName, Double result) {
        Label equation_Name = new Label(equationName);
        Label equation_Result = new Label(result.toString());
        HBox hbEquation = new HBox(10);
        hbEquation.getChildren().addAll(equation_Name, equation_Result);
        
        layout.getChildren().add(hbEquation);
    }
    
    public void showInputs(Stage stage) {
    // Creates the vertical pane to hold the input controls.
        VBox layout = new VBox(VBOX_SPACING);
        layout.setAlignment(TOP_CENTER);
        layout.setStyle("-fx-padding: 20 0 0 0;");
        
    // Age input section.
        Label age = new Label("Age:");
        TextField ageInputField = new TextField ();
        layout.getChildren().addAll(age, ageInputField);
        
    // Weight input section.
    // Kilograms!!!
        Label weight = new Label("Weight:");
        TextField weightInputField = new TextField ();
        layout.getChildren().addAll(weight, weightInputField);
        
    // Height input section.
    // Centimeters!!!
        Label height = new Label("Height:");
        TextField heightInputField = new TextField ();
        layout.getChildren().addAll(height, heightInputField);
        
    // Gender input section.
        final ToggleGroup genderGroup = new ToggleGroup();
        Label gender = new Label("Gender:");
        RadioButton male = new RadioButton("Male");
        male.setToggleGroup(genderGroup);
        RadioButton female = new RadioButton("Female");
        female.setToggleGroup(genderGroup);
        layout.getChildren().addAll(gender, male, female);
        
    // Calculation button, tells the application to mainScreenReturn the values.
        Button calculate = new Button();
        calculate.setText("Calculate responses.");
        calculate.setOnAction((ActionEvent event) -> {
            try {
                Patient patient = new Patient(ageInputField.getText(),
                        weightInputField.getText(),
                        heightInputField.getText(),
                        getGender(genderGroup, male));
                
                showResults(stage, patient);
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
    
    public void showResults(Stage stage, Patient patient) {
    // Creates the gridpane to hold the input controls.
        VBox layout = new VBox(10);
        layout.setAlignment(TOP_CENTER);
        layout.setStyle("-fx-padding: 20 0 0 0;");
        
    // Calculates and shows the results of the predictive equations.
        IPredictive_Equations pe = new Predictive_Equations();// CHANGE.

        if(patient.isGender()) {
            addResult(layout, "MifflinStJeorM:", pe.MifflinStJeorM(patient));
            addResult(layout, "HarrisBenedictM:", pe.HarrisBenedictM(patient));
            addResult(layout, "OwenM:", pe.OwenM(patient));
            addResult(layout, "WHO_FAO_UNUM:", pe.WHO_FAO_UNUM(patient));
            addResult(layout, "WHO_FAO_UNUM_H:", pe.WHO_FAO_UNUM_H(patient));
        }
        else {
            addResult(layout, "MifflinStJeorF:", pe.MifflinStJeorF(patient));
            addResult(layout, "HarrisBenedictF:", pe.HarrisBenedictF(patient));
            addResult(layout, "OwenF:", pe.OwenF(patient));
            addResult(layout, "WHO_FAO_UNUF:", pe.WHO_FAO_UNUF(patient));
            addResult(layout, "WHO_FAO_UNUF_H:", pe.WHO_FAO_UNUF_H(patient));
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