
package javaapplication1;

/**
 *
 * @author Justo Almiron c.i: 5248358
 * TAREA 1 ANALIZADOR LEXICO
 */
public class main {

    /**
     */
    
    public main() {
        int i=0,j=0;
        // inicializamos la entrada
        String entrada =  "{  \n" +
"   \"personas\" : [  \n" +
"      {  \n" +
"         \"ci\":1234567,";
        lexer reservada= new lexer();//objeto para realizar el analisis lexico
        char token[];
        int bandera=0;
        token = new char[entrada.length()]; //array de caracteres para guardar tokens detectados
         
        for(i=0; i< entrada.length(); i++ ){
        
             
             //condicion que detecta caracteres delimitadores, cada vez que detecta un caracter delimitador
             //guarda los tokens y luego se verifica en la funcion si este token es valido para escribir en el archivo de salida
              if(reservada.delimitador(entrada.charAt(i))==0){
                    
                   //la variable bandera nos ayuda a controlar cuando existe mas caracteres delmitadores
                   //cuando deje de haber caracter delimitadores
                   //se analiza la palabra guardada llamando a la funcion
                   //luego se vacia el token para volver a guardar las palabras
                      if(bandera==1){
                      reservada.funcion(token);   
                      token= null;
                      token = new char[entrada.length()];
                      j=0;
                      
                      }
                  
                      bandera=0;
              
              } else {
                  //mientras no contenga un delimitador se guardaran las palabras
                 bandera=1;
                 token[j]= entrada.charAt(i);
                 j++;
              }
            
        
        }
        
        
        
        
        
        System.out.println(reservada.getSalida());
        
        
        
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new main();
        
    }
    
}
