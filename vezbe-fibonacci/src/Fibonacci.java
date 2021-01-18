import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Fibonacci extends Application {
    private int numberValue;
    private int nextNumberValue;
    private Label number;

    private Button previous, next;

    class PreviousHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (numberValue == 0) {
                return;
            }
            int incomingNumber = nextNumberValue - numberValue;
            nextNumberValue = numberValue;
            numberValue = incomingNumber;
            number.setText(String.format("%d", numberValue));
            if (numberValue == 0) {
                previous.setDisable(true);
            }
        }
    }

    class NextHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (numberValue == 0) {
                previous.setDisable(false);
            }
            int incomingNumber = nextNumberValue + numberValue;
            numberValue = nextNumberValue;
            nextNumberValue = incomingNumber;
            number.setText(String.format("%d", numberValue));
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(initBase(), 600, 400);
        stage.setScene(scene);
        stage.setTitle("Hello world!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private BorderPane initBase() {
        BorderPane base = new BorderPane();

        numberValue = 0;
        nextNumberValue = 1;
        number = new Label(String.format("%d", numberValue));
        number.setFont(new Font(36));

        base.setCenter(number);
        base.setBottom(initControls());

        return base;
    }

    private FlowPane initControls() {
        FlowPane ctrls = new FlowPane();
        ctrls.setAlignment(Pos.CENTER);
        ctrls.setPadding(new Insets(16));
        ctrls.setHgap(16);

        previous = new Button();
        previous.setText("Previous");
        previous.setOnAction(new PreviousHandler());
        previous.setDisable(true);

        next = new Button();
        next.setText("Next");
        next.setOnAction(new NextHandler());

        ctrls.getChildren().addAll(previous, next);

        return ctrls;
    }
}
