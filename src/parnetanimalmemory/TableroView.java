/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parnetanimalmemory;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
/**
 *
 * @author José
 */
public class TableroView {
   // Cargamos las imagenes un sola vez.
    Image imageBurro = new Image(getClass().getResourceAsStream("/img/burro.png"));
    Image imageCastor = new Image(getClass().getResourceAsStream("/img/castor.png"));
    Image imageElefante = new Image(getClass().getResourceAsStream("/img/elefante.png"));
    Image imageFoca = new Image(getClass().getResourceAsStream("/img/foca.png"));
    Image imageGallina = new Image(getClass().getResourceAsStream("/img/gallina.png"));
    Image imageLeon = new Image(getClass().getResourceAsStream("/img/leon.png"));
    Image imageMono = new Image(getClass().getResourceAsStream("/img/mono.png"));
    Image imageOso = new Image(getClass().getResourceAsStream("/img/oso.png"));
    Image cartaOculta = new Image(getClass().getResourceAsStream("/img/cartaOculta.gif"));
    
    // Creación de la matriz empleada.
    public char[][] matrizTablero = new char [4][4];
    int filas = 4;
    int columnas = 4;
    
    GridPane gridTablero = new GridPane();
    public final double TAM_CASILLA = 150;
    
    ArrayList<ImageView> listaCartas = new ArrayList();
        
    public GridPane getGridTablero () {
        return gridTablero;
    }
    
    public void mostrarTablero() {
        for(int y=0; y< columnas; y++) {
            for(int x=0; x< filas; x++) {
                System.out.print(matrizTablero[x][y]);
                rellenarCasilla(x, y);
                ponerCartaOculta(x, y);
            }
            System.out.println();
        }
    }

    private void rellenarCasilla(int x, int y) {
        // Dibujar casillas como un cuadrado 
        Rectangle r = new Rectangle(TAM_CASILLA, TAM_CASILLA, Color.GREEN);
        r.setStroke(Color.GREEN);
        gridTablero.add(r, x, y);
        ponerFoto(x, y);
    }
     
    public void ponerFoto2(int x, int y, char foto) {
        matrizTablero[x][y] = foto;
    }
     
    public void ponerFoto(int x, int y) {
                switch(matrizTablero[x][y]) {
                    case 'B':   
                        ImageView imageBurro1 = new ImageView(imageBurro);
                        imageBurro1.setFitWidth(TAM_CASILLA);
                        imageBurro1.setFitHeight(TAM_CASILLA);
                        gridTablero.add(imageBurro1, x, y);
                        break;
                    case 'C' :
                        ImageView imageCastor1 = new ImageView(imageCastor); 
                        imageCastor1.setFitWidth(TAM_CASILLA);
                        imageCastor1.setFitHeight(TAM_CASILLA);
                        gridTablero.add(imageCastor1, x, y);
                        break;   
                    case 'E' :
                        ImageView imageElefante1 = new ImageView(imageElefante);
                        imageElefante1.setFitWidth(TAM_CASILLA);
                        imageElefante1.setFitHeight(TAM_CASILLA);
                        gridTablero.add(imageElefante1, x, y);
                        break;
                    case 'F' :
                        ImageView imageFoca1 = new ImageView(imageFoca);
                        imageFoca1.setFitWidth(TAM_CASILLA);
                        imageFoca1.setFitHeight(TAM_CASILLA);
                        gridTablero.add(imageFoca1, x, y);
                        break;
                    case 'G' :
                        ImageView imageGallina1 = new ImageView(imageGallina);
                        imageGallina1.setFitWidth(TAM_CASILLA);
                        imageGallina1.setFitHeight(TAM_CASILLA);
                        gridTablero.add(imageGallina1, x, y);
                        break;
                    case 'L' :
                        ImageView imageLeon1 = new ImageView(imageLeon);
                        imageLeon1.setFitWidth(TAM_CASILLA);
                        imageLeon1.setFitHeight(TAM_CASILLA);
                        gridTablero.add(imageLeon1, x, y);
                        break;
                    case 'M' :
                        ImageView imageMono1 = new ImageView(imageMono);
                        imageMono1.setFitWidth(TAM_CASILLA);
                        imageMono1.setFitHeight(TAM_CASILLA);
                        gridTablero.add(imageMono1, x, y);
                        break;
                    case 'O' :
                        ImageView imageOso1 = new ImageView(imageOso);
                        imageOso1.setFitWidth(TAM_CASILLA);
                        imageOso1.setFitHeight(TAM_CASILLA);
                        gridTablero.add(imageOso1, x, y);
                        break;   
                }
    }
    
    public void ponerCartaOculta(int x, int y) {
//        System.out.println("ponerCartaOculta: " + x + "," + y);
            ImageView cartaOculta1 = new ImageView(cartaOculta);
            cartaOculta1.setFitWidth(TAM_CASILLA);
            cartaOculta1.setFitHeight(TAM_CASILLA);
            gridTablero.add(cartaOculta1, x, y);
            listaCartas.add(cartaOculta1);     
    }
    
    public void cambiarCartas() {
        for(ImageView imageViewCarta:listaCartas) {
            imageViewCarta.setVisible(false);
        }
    }
        // Game loop usando Timeline
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
                public void handle(ActionEvent ae) {
                    for(ImageView imageViewCarta:listaCartas) {
                        imageViewCarta.setVisible(true);
                    }
                    timeline.stop();
                    System.out.println("Se ha parado la animación");
                }
            })                
        );  
        
    public void levantarCarta (int x, int y) {
        int levantaCarta = (y * columnas + x);
        listaCartas.get(levantaCarta).setVisible(false);
        
        System.out.println(levantaCarta);
        System.out.println(listaCartas.size()); 
    }
    
}