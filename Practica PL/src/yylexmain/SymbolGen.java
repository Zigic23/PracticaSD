/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yylexmain;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class SymbolGen {
    public String valor, id;
    public ArrayList<SymbolFunc> funs;
    public ArrayList<String> param;
    public SymbolFunc fun;
    public SymbolGen(){
        valor = "";
        funs = new ArrayList<>();
    }
    
    @Override
    public String toString(){
        return valor;
    }
}
