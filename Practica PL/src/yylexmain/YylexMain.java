/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 package yylexmain;
 
/**
 *
 * @author Diego
 */
public class YylexMain {

    /**
     * @param argv the command line arguments
     */
    public static void main(String argv[]){
        if (argv.length == 0) {
            System.out.println("Inserta nombre de archivo\n"+
            "( Usage : java Analizador <inputfile> )");
        } else if (argv.length == 1){
            for (int i = 0; i < argv.length; i++) {
                AnalizadorLexico lexico = null;
                try {
                    lexico = new AnalizadorLexico( new java.io.FileReader(argv[i]));
                    parser sintactico = new parser(lexico);
                    sintactico.parse();
                    System.out.println("Entrada correcta");
                }
                catch (java.io.FileNotFoundException e) {
                    System.out.println("Archivo \""+argv[i]+"\" no encontrado.");
                }
                catch (java.io.IOException e) {
                    System.out.println("Error durante la lectura del"
                    + " archivo \""+argv[i]+"\".");
                    e.printStackTrace();
                }
                catch (Exception e) {
                    System.out.println("Excepcion:");
                    e.printStackTrace();
                }
            }
        }
    }
    
}
