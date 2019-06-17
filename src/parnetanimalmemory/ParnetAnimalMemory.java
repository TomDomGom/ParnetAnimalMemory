/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parnetanimalmemory;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Random;


/**
 *
 * @author TomDomGom
 */
public class ParnetAnimalMemory extends Application {
    
    // Variables .
//    Random aleatorio;
    
    @Override
    public void start(Stage primaryStage) {

    
        
    }

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        
        // Variables para la matriz.
        final int COLUMNAS = 4;
        final int FILAS = 4 ;
        Random r = new Random();
        char[][] letras = new char[FILAS][COLUMNAS];
        //char[] letraQueToca = 'A';
        String letraQueToca = "ABCDEFGH";
        int tamano = letraQueToca.length();
 
        //Carga las letras en la matriz
        for(int f=0; f<FILAS; f++) {
            for(int c=0; c<COLUMNAS; c++) {
                letras[f][c] = letraQueToca.charAt(r.nextInt(tamano));
            }
        }
 
        //Mostrar en pantalla la matriz
        for(int f=0; f<FILAS; f++) {
            for(int c=0; c<COLUMNAS; c++) {
                System.out.print(letras[f][c]+ "\t");
            }
           System.out.println(); 
        }
        
    }
    
}
