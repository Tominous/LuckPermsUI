import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import me.lucko.luckperms.standalone.util.ColoredLine;

public class ColoredLineTest extends Application {

    @BeforeClass
    public static void initJavaFX() {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Platform.exit();
    }

    @Test
    public void lineParser() {
        ColoredLine coloredLine;
        coloredLine = new ColoredLine("&6Maker&cTim &ais &6Awesome!");
        assertEquals("Amount of colourblocks found", 4, coloredLine.getChildren().size());
        coloredLine = new ColoredLine("Maker&cTim &ais &6Awesome!");
        assertEquals("Amount of colourblocks found", 4, coloredLine.getChildren().size());
        coloredLine = new ColoredLine("MakerTim is Awesome!");
        assertEquals("Amount of colourblocks found", 1, coloredLine.getChildren().size());
        coloredLine = new ColoredLine("MakerTim &ais Awesome!");
        assertEquals("Amount of colourblocks found", 2, coloredLine.getChildren().size());
        coloredLine = new ColoredLine("MakerTim &a&ais Awesome!");
        assertEquals("Amount of colourblocks found", 3, coloredLine.getChildren().size());
        coloredLine = new ColoredLine("MakerTim is Awesome!&a");
        assertEquals("Amount of colourblocks found", 2, coloredLine.getChildren().size());

    }

}
