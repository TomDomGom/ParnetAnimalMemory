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
    // Random aleatorio;
    
    @Override
    public void start(Stage primaryStage) {

    
        
    }

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
        public static void main(String[] args) {
        
        // Variables para la matriz.
        final int COLUMNAS = 4;
        final int FILAS = 4 ;
        int filasRan;
        int columnasRan;
                 
        Random r = new Random();
        filasRan = r.nextInt(FILAS);
        columnasRan = r.nextInt(COLUMNAS);
        
        char[][] letras = new char[FILAS][COLUMNAS];
        char letraQueToca = 'A';
        //String letraQueToca = "ABCDEFGH";
        // int letra = letraQueToca.length();
 
        
        // Empezamos con la letra A. en posición aleatoria. cada letra tiene que estar pintada 2 veces en la matriz.
        // y luego una vez que la letra fuese pintada incrementar por la siguiente del abecedario.
        
        // antes de colocar una letra, entramos en un bucle mientras la posición
        //  generada aleatoriamente esté ocupada, generando dentro del bucle
        //  nuevas posiciones
        // Al salir del bucle se coloca la letra
            
            // Creamos un bucler for cual se repetira 8 veces.
            for (int i = 0; i < 8; i++) {
 
            // Antes de colocar una letra preguntamos por posición vacia.
            if (letras[filasRan][columnasRan] != 0){ // Casilla distinta a 0 generamos posiciones. nuevas.
                // Generamos con while posiciones aleatorias distinta a 0 para colocar las letras en toda la matriz.
                while (letras[filasRan][columnasRan] != 0){
                    
                    filasRan = r.nextInt(FILAS);
                    columnasRan = r.nextInt(COLUMNAS);

                }
                //Pintamos la letra.
                letras[filasRan][columnasRan]= letraQueToca;
                
            } else { // casilla a 0 esta libre ponemos la letra.
                
                letras[filasRan][columnasRan] = letraQueToca;
                filasRan = r.nextInt(FILAS);
                columnasRan = r.nextInt(COLUMNAS);                
            }
        
            // Antes de colocar una letra preguntamos por posición vacia.
            if (letras[filasRan][columnasRan] != 0){ // Casilla distinta a 0 generamos posiciones. nuevas.

                while (letras[filasRan][columnasRan] != 0){
                    
                    filasRan = r.nextInt(FILAS);
                    columnasRan = r.nextInt(COLUMNAS);
                    
                }
                
                letras[filasRan][columnasRan]= letraQueToca;
                
            } else { // casilla a 0 esta libre ponemos la letra.
                
                letras[filasRan][columnasRan] = letraQueToca;
                filasRan = r.nextInt(FILAS);
                columnasRan = r.nextInt(COLUMNAS);
                
            }
            
            // Incremento de la letra.
            letraQueToca++;
            
        }      
        
        //Mostrar en pantalla la matriz
        for(int f=0; f<FILAS; f++) {
            for(int c=0; c<COLUMNAS; c++) {
                System.out.print(letras[f][c]+ "\t");
            }
           System.out.println(); 
        }
 
    }// Final del Main.
    
}// Final de la Clase.
