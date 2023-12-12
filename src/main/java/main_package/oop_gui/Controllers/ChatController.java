package main_package.oop_gui.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    private final ArrayList<Message> messages;

    @FXML
    private TextField textBox;

    @FXML
    private VBox vboxMess;

    @FXML
    private ScrollPane sp_main;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vboxMess.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sp_main.setVvalue((Double) t1);
            }
        });
    }

    public ChatController() {
        messages = new ArrayList<>();
    }

    public void getText() {
        if (textBox.getText().isBlank()) {
            return;
        }
        Message newMessage = new Message();
        newMessage.setMessage(textBox.getText());
        newMessage.setSide("left");
        addMessage(newMessage);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);

        Label label = new Label(newMessage.getMessage());
        label.getStylesheets().add(getClass().getResource("/main_package/oop_gui/css/chat.css").toExternalForm());
        label.getStyleClass().add("chat_bubble");
        label.setId("left");
        label.setWrapText(true);

        hbox.getChildren().add(label);
        vboxMess.getChildren().add(hbox);

        textBox.clear();
        printHistory();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void print(Message message) {
        System.out.println(message.getMessage());
        System.out.println(message.getSide());
    }

    public void printHistory() {
        System.out.println("Chat history contains: " + messages.size() + " messages: ");
        for (Message message : messages) {
            System.out.println('\"' + message.getMessage() + "\" from side: " + message.getSide());
        }
    }
}
