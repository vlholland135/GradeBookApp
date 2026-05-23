/**
 * HollandGradeBookApp.java
 *
 * Capstone Project - Sprint 1: User Interface (Assignment 10.2)
 *
 * This program serves as the graphical user interface for the GradeBookApp,
 * developed for OpenEdX's student performance tracking tool. The UI allows
 * users to enter student grade information including first name, last name,
 * course name, and a letter grade selected from a drop-down menu. Three
 * action buttons are provided for saving entries, clearing the form, and
 * viewing saved records. Event handling will be implemented in Sprint 2.
 *
 * CIS-505: Java Programming
 * Author: Victoria Holland
 * Date: May 2026
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Main application class for the GradeBookApp.
 *
 * Extends Application to launch the JavaFX runtime. Builds and displays
 * the grade entry form, action buttons, and results display area within
 * a single primary stage.
 */
public class HollandGradeBookApp extends Application {

    /**
     * Constructs and displays the primary stage for the GradeBookApp UI.
     *
     * Initializes all form labels, input fields, the grade ComboBox,
     * action buttons, and the read-only results area.
     *
     * @param primaryStage the main window provided by the JavaFX runtime
     */
    @Override
    public void start(Stage primaryStage) {

        Text appTitle = new Text("GradeBook Application");
        appTitle.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel  = new Label("Last Name:");
        Label courseLabel    = new Label("Course:");
        Label gradeLabel     = new Label("Grade:");

        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Enter first name");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Enter last name");

        TextField courseField = new TextField();
        courseField.setPromptText("Enter course name");

        ComboBox<String> gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");
        gradeComboBox.setPromptText("Select grade");
        gradeComboBox.setPrefWidth(200);

        GridPane formGrid = new GridPane();
        formGrid.setHgap(15);
        formGrid.setVgap(12);
        formGrid.setPadding(new Insets(10, 20, 10, 20));
        formGrid.setAlignment(Pos.CENTER);

        formGrid.add(firstNameLabel, 0, 0);
        formGrid.add(firstNameField, 1, 0);
        formGrid.add(lastNameLabel, 0, 1);
        formGrid.add(lastNameField, 1, 1);
        formGrid.add(courseLabel, 0, 2);
        formGrid.add(courseField, 1, 2);
        formGrid.add(gradeLabel, 0, 3);
        formGrid.add(gradeComboBox, 1, 3);

        Button saveButton  = new Button("Save Entry");
        Button clearButton = new Button("Clear Form");
        Button viewButton  = new Button("View Grades");

        saveButton.setPrefWidth(120);
        clearButton.setPrefWidth(120);
        viewButton.setPrefWidth(120);

        saveButton.setStyle("-fx-background-color: #2E86AB; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px;");
        clearButton.setStyle("-fx-background-color: #A8DADC; -fx-text-fill: #1D3557; -fx-font-size: 13px;");
        viewButton.setStyle("-fx-background-color: #457B9D; -fx-text-fill: white; -fx-font-size: 13px;");

        HBox buttonRow = new HBox(15, saveButton, clearButton, viewButton);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.setPadding(new Insets(10, 0, 10, 0));

        Label resultsLabel = new Label("Grade Entries:");
        resultsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        TextArea resultsArea = new TextArea();
        resultsArea.setEditable(false);
        resultsArea.setPromptText("  Saved grade entries will appear here...");
        resultsArea.setPrefHeight(200);
        resultsArea.setPrefWidth(450);
        resultsArea.setStyle("-fx-font-family: monospace; -fx-font-size: 12px;");

        VBox resultsBox = new VBox(8, resultsLabel, resultsArea);
        resultsBox.setPadding(new Insets(10, 20, 10, 20));

        Separator separator = new Separator();
        separator.setPadding(new Insets(5, 20, 5, 20));

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: #F1FAEE;");

        root.getChildren().addAll(appTitle, formGrid, buttonRow, separator, resultsBox);

        Scene scene = new Scene(root, 520, 530);
        primaryStage.setTitle("GradeBook Application");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    } // end start()

    /**
     * Application entry point. Delegates to the JavaFX launch() method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    } // end main()

} // end class HollandGradeBookApp
