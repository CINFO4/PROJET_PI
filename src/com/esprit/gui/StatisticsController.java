package com.esprit.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StatisticsController implements Initializable {

    @FXML
    private PieChart chart;

    private ObservableList<String> selectedTypes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the statistics interface
        initializeChart();
    }

    private void initializeChart() {
        // Generate sample statistics data
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Type 1", 30),
                new PieChart.Data("Type 2", 20),
                new PieChart.Data("Type 3", 50)
        );

        // Set the data to the chart
        chart.setData(pieChartData);
        chart.setLegendVisible(false);
    }
      public void setSelectedTypes(List<String> selectedTypes) {
        this.selectedTypes = FXCollections.observableArrayList(selectedTypes);
    }

    private void goBack() {
        // Handle the "Back" button click
        // You can redirect to the previous interface or perform any other action
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Back");
        alert.setHeaderText(null);
        alert.setContentText("Redirecting back to the previous interface.");
        alert.showAndWait();
    }
}
