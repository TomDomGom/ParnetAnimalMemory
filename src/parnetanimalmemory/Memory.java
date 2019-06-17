/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parnetanimalmemory;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author José
 */
public class Memory extends Application {
    @Override
    public void start(Stage primaryStage) {

        TableroView tableroView = new TableroView();
        
        tableroView.ponerFoto2(0, 0, 'B');
        tableroView.ponerFoto2(0, 1, 'C');
        tableroView.ponerFoto2(0, 2, 'F');
        tableroView.ponerFoto2(0, 3, 'E');
        tableroView.ponerFoto2(1, 0, 'M');
        tableroView.ponerFoto2(1, 1, 'L');
        tableroView.ponerFoto2(1, 2, 'G');
        tableroView.ponerFoto2(1, 3, 'O');
        
        tableroView.ponerFoto2(2, 0, 'B');
        tableroView.ponerFoto2(2, 1, 'C');
        tableroView.ponerFoto2(2, 2, 'F');
        tableroView.ponerFoto2(2, 3, 'E');
        tableroView.ponerFoto2(3, 0, 'M');
        tableroView.ponerFoto2(3, 1, 'L');
        tableroView.ponerFoto2(3, 2, 'G');
        tableroView.ponerFoto2(3, 3, 'O');
        
        tableroView.mostrarTablero();
                
        // Contenedor para alinear el tablero en centro horizontalmente
        HBox hBox = new HBox(tableroView.getGridTablero());
        hBox.setAlignment(Pos.CENTER);
        
        // Contenedor secundario para alinear los botones en centro horizontalmente
        HBox hBoxBotones = new HBox(); 
        hBoxBotones.setPadding(new Insets(15, 12, 15, 12));
        hBoxBotones.setSpacing(10);
        hBoxBotones.setAlignment(Pos.CENTER);
        
        Button buttonJugar = new Button("Jugar");
        buttonJugar.setPrefSize(100, 20);

        Button buttonSalir = new Button("Salir");
        buttonSalir.setPrefSize(100, 20);
        
        hBoxBotones.getChildren().addAll(buttonJugar, buttonSalir);
        
        // Contenedor principal será de tipo VBox para centrar tablero verticalmente
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(hBoxBotones);
        root.getChildren().add(hBox);
        
        Scene scene = new Scene(root, 700, 700);
        primaryStage.setTitle("Memory");
        primaryStage.setScene(scene);
        primaryStage.show();
       
        buttonJugar.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                tableroView.cambiarCartas();
                tableroView.timeline.play(); 
                tableroView.timeline.setCycleCount(Timeline.INDEFINITE); 
            }
        });
        
        buttonSalir.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent e) {
                primaryStage.close();
            }
        });
        
        tableroView.gridTablero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int contadorClick = 0;
            @Override
            public void handle(MouseEvent mouseEvent) { 
               
                // Insertar aquí el código a ejecutar cuando se haga clic en el ratón
                System.out.println("Mouse clicked X: " + Math.floor(mouseEvent.getX() / tableroView.TAM_CASILLA) + " Y: " + Math.floor(mouseEvent.getY() / tableroView.TAM_CASILLA));
                
                double x = (mouseEvent.getX() / tableroView.TAM_CASILLA);
                int x1 = (int)x;
                
                double y = (mouseEvent.getY() / tableroView.TAM_CASILLA);
                int y1 = (int)y;
               
                System.out.println("Se ha hecho click: " + contadorClick++);
                
                if (contadorClick <=2) {
                    tableroView.levantarCarta(x1, y1);
                }
                
                // También se puede comprobar sobre qué botón se ha actuado,
                //  válido para cualquier acción (pressed, released, clicked, etc) 
                if(mouseEvent.getButton() == MouseButton.PRIMARY) {
                    System.out.println("Botón principal");
                    System.out.println("----------------");
                }
                if(mouseEvent.getButton() == MouseButton.SECONDARY) {
                    System.out.println("Botón secundario");
                    System.out.println("----------------");
                }
            }
        });
    }   
}