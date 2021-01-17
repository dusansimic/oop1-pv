import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Fibonacci extends Application {
    private int lastNumberValue;
    private int numberValue;
    private Label number;

    private Button previous, next;

    class PreviousHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (lastNumberValue <= 0) {
                lastNumberValue = 0;
                numberValue = 0;
            } else {
                int nextNumber = numberValue - lastNumberValue;
                numberValue = lastNumberValue;
                lastNumberValue = nextNumber;
            }
            number.setText(String.format("%d", numberValue));
        }
    }

    class NextHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (numberValue == 0) {
                lastNumberValue = 0;
                numberValue = 1;
            } else {
                int nextNumber = numberValue + lastNumberValue;
                lastNumberValue = numberValue;
                numberValue = nextNumber;
            }

            number.setText(String.format("%d", numberValue));
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(initBase());
        stage.setScene(scene);
        stage.setTitle("Hello world!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private BorderPane initBase() {
        BorderPane base = new BorderPane();

        lastNumberValue = 0;
        numberValue = 0;
        number = new Label(String.format("%d", numberValue));
        number.setFont(new Font(36));

        base.setCenter(number);
        base.setBottom(initControls());

        return base;
    }

    private BorderPane initControls() {
        BorderPane wrapper = new BorderPane();
        HBox controls = new HBox();

        previous = new Button();
        previous.setText("Previous");
        previous.setOnAction(new PreviousHandler());

        next = new Button();
        next.setText("Next");
        next.setOnAction(new NextHandler());

        controls.getChildren().addAll(previous, next);
        controls.setPadding(new Insets(16));
        controls.setSpacing(16);

        // Iz neko grazloga BorderPane ne želi da mi nacentrira HBox. Ovo bi trebalo da radi da mi ta dva dugmeta
        // konstantno budu u sredni, isto ponašanje kao za labelu sa brojem.
        wrapper.setCenter(controls);

        return wrapper;
    }
}
