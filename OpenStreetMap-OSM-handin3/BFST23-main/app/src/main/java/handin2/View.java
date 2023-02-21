package handin2;

import java.util.Iterator;

import org.checkerframework.checker.units.qual.C;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.stage.Stage;

public class View {
    Canvas canvas = new Canvas(640, 480);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    double x1 = 100;
    double y1 = 100;
    double x2 = 200;
    double y2 = 800;

    Affine trans = new Affine();

    Model model;

    public View(Model model, Stage primaryStage) {
        this.model = model;
        primaryStage.setTitle("Draw Lines");
        BorderPane pane = new BorderPane(canvas);
        Scene scene = new Scene(pane);
        Menu menu1 = new Menu("Change Color");
        MenuBar menubar = new MenuBar(menu1);
        pane.setTop(menubar);
        primaryStage.setScene(scene);
        primaryStage.show();
        redraw();
        pan(-0.56*model.minlon, model.maxlat);
        zoom(0, 0, canvas.getHeight() / (model.maxlat - model.minlat));
    }

    void redraw() {
        gc.setTransform(new Affine());
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setTransform(trans);
        gc.setLineWidth(1/Math.sqrt(trans.determinant()));
        for (var line : model.lines) {
            line.draw(gc);
        }
        for (var way : model.ways) {
            gc.setStroke(Color.BLACK);
            way.draw(gc);
        }
        for (var water : model.waters) {
            gc.setFill(Color.AQUA);
            water.draw(gc);
            gc.fill();
        }
        for (var building : model.buildings) {
            gc.setFill(Color.GAINSBORO);
            building.draw(gc);
            gc.fill();
        }
        for (var park : model.parks) {
            gc.setFill(Color.LIGHTGREEN);
            park.draw(gc);
            gc.fill();
        }
        for (var garden : model.gardens) {
            gc.setFill(Color.PALEGREEN);
            garden.draw(gc);
            gc.fill();
        }
        for (var forest : model.forests) {
            gc.setFill(Color.FORESTGREEN);
            forest.draw(gc);
            gc.fill();
        }
        // for (var asphaltroad : model.asphaltroads) {
        //     gc.setFill(Color.GAINSBORO);
        //     asphaltroad.draw(gc);
        //     gc.fill();
        // }
    }
    void pan(double dx, double dy) {
        trans.prependTranslation(dx, dy);
        redraw();
    }

    void zoom(double dx, double dy, double factor) {
        pan(-dx, -dy);
        trans.prependScale(factor, factor);
        pan(dx, dy);
        redraw();
    }

    public Point2D mousetoModel(double lastX, double lastY) {
        try {
            return trans.inverseTransform(lastX, lastY);
        } catch (NonInvertibleTransformException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }

    }
}