/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parnetanimalmemory;

import java.util.Random;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author TomDomGom
 */
public class ParnetAnimalMemory extends Application {
    Random aleatorio;
    
    int FILARAND  = 0;
    int COLUMNARAND = 0;
    final int FILAS = 4;
    final int COLUMNAS = 4;
    
    @Override
    public void start(Stage primaryStage) {

    
        
    }

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
  
        aleatorio = new Random();
        FILARAND = random.nextInt(FILAS);
        COLUMNARAND = random.nextInt(COLUMNAS)
        
        char[][] letras = new char[FILARAND][COLUMNARAND];
        char letraQueToca = 'A';
 
        //Carga las letras en la matriz
        for(int f=0; f<FILARAND; f++) {
            for(int c=0; c<COLUMNARAND; c++) {
                letras[f][c] = letraQueToca;
                letraQueToca++;
            }
        }
 
        //Mostrar en pantalla la matriz
        for(int f=0; f<FILARAND; f++) {
            for(int c=0; c<COLUMNARAND; c++) {
                System.out.print(letras[f][c]+"\t");
            }
           System.out.println(); 
        }
        
    }
    
}
