package UI;

import Domain.Event;
import Service.EventService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller{
    public EventService service;

    public TableView tableViewEvent;
    public TableColumn tableColumnId;
    public TableColumn tableColumnName;
    public TableColumn tableColumnDate;
    public TableColumn tableColumnDuration;
    public TableColumn tableColumnTime;
    public TextField txtDateForMaxEvent;
    public Label max;
    public Button btnAdd;
    public Button btnMax;

    private ObservableList<Event> event = FXCollections.observableArrayList();


    public void setServices(EventService service) {
        this.service = service;
    }
    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            event.addAll(service.getAll());
            tableViewEvent.setItems(event);
        });
    }
    @FXML
    public void btnAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("eventAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add event");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            EventAddController controller = fxmlLoader.getController();
            controller.setServices(service);
            stage.showAndWait();
            event.clear();
            event.addAll(service.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Event update.", e);
        }
    }

    public void btnMaxClick(ActionEvent actionEvent) {
        String a = txtDateForMaxEvent.getText();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM");

        try {
            format.parse(txtDateForMaxEvent.getText());
        } catch (ParseException rex) {
            Common.showValidationError(rex.getMessage());
        }

        int maxOfAll = -1;

        List<Event> all = service.getAll();
        for (Event i : all) {
            if (i.getDay().equals(a)) {
                if (maxOfAll < i.getDuration() ) {
                    maxOfAll = i.getDuration();
                }
            }
        }
        if (maxOfAll == -1) {
            throw new RuntimeException("There is no event for the specified date.");
        }
        else {
            max.setText(maxOfAll + "");
        }
    }


}
