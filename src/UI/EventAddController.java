package UI;

import Service.EventService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EventAddController {
    public TextField spnId;
    public TextField txtEventName;
    public TextField txtEventDay;
    public TextField txtEventDuration;
    public TextField txtEventTime;
    public Button btnAdd;
    public Button btnCancel;

    private EventService service;



    public void setServices(EventService service) {
        this.service = service;
    }

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = spnId.getText();
            String name = txtEventName.getText();
            String day = txtEventDay.getText();
            int duration = Integer.parseInt( txtEventDuration.getText() );
            String time = txtEventTime.getText();
            service.insert( id,  name,  day, duration, time);
            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void btnCancelClick(ActionEvent actionEvent) {

        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

}
