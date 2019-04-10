import Domain.EventValidator;
import Repository.InMemoryRepository;
import Service.EventService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
        Parent root = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        EventValidator validator = new EventValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        EventService service = new EventService(repository);

        service.insert("1", "teatru", "20.04", 60, "12.00");
        service.insert("2", "opera", "21.03", 80, "18.00");
        service.insert("3", "interviu", "12.08", 20, "15.00");
        service.insert("4", "film", "10.09", 120, "21.00");
        service.insert("5", "intalnire", "10.09", 30, "20.00");
        service.insert("6", "fundraiser", "10.09", 40, "11.20");

        controller.setServices(service);


        primaryStage.setTitle("Event manager");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
