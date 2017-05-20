/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 package yylexmain;
 
import java.io.PrintWriter;

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
                    lexico = new AnalizadorLexico( new java.io.FileReader(argv[i]),true);
                    parser sintactico = new parser(lexico);
                    int barr = argv[0].lastIndexOf("\\");
                    String arc = argv[0].substring(barr+1, argv[0].length());               
                    String total = "<html>\n<head><style>\n" +
                            ".cte {color:rgb(19,189,72);}\n" +
                            ".ident {color:rgb(50,40,244);}\n" +
                            ".palres {color:rgb(0,0,0);font-weight:bold;}\n" +
                            "</style>\n\t<title>" + arc + "</title>\n</head>\n"
                            + "<BODY>\n"
                            + "\t<h1>Programa: " + arc + "</h1>";
                    total += sintactico.parse().value.toString();
                    PrintWriter writer = new PrintWriter(arc + ".html", "UTF-8");
                    writer.println(total);
                    writer.close();
                    System.out.println();
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
