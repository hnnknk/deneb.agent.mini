package xyz.hnnknk.deneb.agent.mini;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * The main class.
 */
public class Main extends Application {

    @Override
    public final void start(final Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                getClass().getClassLoader().getResource("sample.fxml")));

        primaryStage.setTitle("Deneb mini agent");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(final String[] args)  {

        launch(args);
    }
}
