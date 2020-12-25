import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {
    private ObservableList<String> lista;

    private TextField predmet;
    private TextField vrednost;
    private Button addItem;
    private Button print;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Checkout");

        stage.setScene(new Scene(initGui()));
        stage.setResizable(false);
        stage.show();
    }

    public HBox initGui() {
        HBox root = new HBox();
        root.getChildren().addAll(initControls(), initList());
        return root;
    }

    public ListView initList() {
        lista = FXCollections.observableArrayList();
        ListView<String> list = new ListView<String>();
        list.setItems(lista);
        return list;
    }

    public VBox initControls() {
        VBox vbox = new VBox();

        predmet = new TextField();
        vrednost = new TextField();
        addItem = new Button();
        addItem.setText("Add item");
        addItem.setOnAction(e -> {
            try {
                lista.add(predmet.getText() + " - " + Integer.parseInt(vrednost.getText()));
            } catch (NumberFormatException err) {
                new Alert(Alert.AlertType.ERROR, "Neispravan format vrednosti!").showAndWait();
                System.err.println(err.getMessage());
            } catch (Exception err) {
                new Alert(Alert.AlertType.ERROR, err.getMessage()).showAndWait();
                System.err.println(err.getMessage());
            }
        });
        print = new Button();
        print.setText("Print");
        print.setOnAction(e -> {
            try {
                stampaj();
                lista.clear();
            } catch (IOException err) {
                new Alert(Alert.AlertType.ERROR, "Štampanje neuspešno!").showAndWait();
                System.err.println(err.getMessage());
            } catch (Exception err) {
                new Alert(Alert.AlertType.ERROR, err.getMessage()).showAndWait();
                System.err.println(err.getMessage());
            }
        });

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5));
        vbox.getChildren().addAll(predmet, vrednost, addItem, print);

        return vbox;
    }

    private void stampaj() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("res/out.txt"));

        for (String el : lista) {
            out.write(el);
            out.newLine();
        }

        out.flush();
        out.close();
    }
}
