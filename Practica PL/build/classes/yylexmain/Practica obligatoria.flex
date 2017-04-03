package yylexmain;
import java_cup.runtime.*;
%%
%class AnalizadorLexico
%unicode
%cup
%eofval{
  return new Symbol(sym.EOF);
%eofval}
%{
	AnalizadorLexico(java.io.Reader in, boolean deb) {
		this.zzReader = in;
		this.debug = deb;
	}
	boolean debug = false;
	boolean getEndOfFile(){
		return zzAtEOF;
	}
%}
ident = ([$]|{let})[a-zA-Z0-9$_.]+
let = [a-zA-Z]
constint = ({decint}|{octint}|{hexint})
constfloat = ({decreal}|{octreal}|{hexreal})
decint = [+|-]?[0-9]+
octint = [0][+|-]?[0-7]+
hexint = "0x"[+|-]?[0-9A-F]+
decreal = {decint}"."[0-9]+
octreal = {octint}"."[0-7]+
hexreal = {hexint}"."[0-9A-Z]+
constlit = "'"([^']|"\\'")+"'"
comentario = ({barrab}|{barraa})
barrab = "//"[^\n]+
barraa = "/*"([^*]|"*"[^/])+"*/"

%%
" - " {if (debug){System.out.println("menos");}
		return new Symbol(sym.menos);}
" + " {if (debug){System.out.println("mas");}
		return new Symbol(sym.mas);}
" * " {if (debug){System.out.println("mul");}
		return new Symbol(sym.mul);}
" / " {if (debug){System.out.println("div");}
		return new Symbol(sym.div);}
" % " {if (debug){System.out.println("rest");}
		return new Symbol(sym.rest);}
"(" {if (debug){System.out.println("para");}
		return new Symbol(sym.para);}
")" {if (debug){System.out.println("parc");}
		return new Symbol(sym.parc);}
";" {if (debug){System.out.println("puntc");}
		return new Symbol(sym.puntc);}
"," {if (debug){System.out.println("coma");}
		return new Symbol(sym.coma);}
"=" {if (debug){System.out.println("igual");}
		return new Symbol(sym.igual);}
"{" {if (debug){System.out.println("llava");}
		return new Symbol(sym.llava);}
"}" {if (debug){System.out.println("llavc");}
		return new Symbol(sym.llavc);}
"void" {if (debug){System.out.println("voidd");}
		return new Symbol(sym.voidd);}
"int" {if (debug){System.out.println("intt");}
		return new Symbol(sym.intt);}
"float" {if (debug){System.out.println("floatt");}
		return new Symbol(sym.floatt);}
"return" {if (debug){System.out.println("returnn");}
		return new Symbol(sym.returnn);}
{ident} {if(debug){System.out.println("ident");}
		return new Symbol(sym.ident, yytext());}
{constint} {if (debug){System.out.println("constint");}
		return new Symbol(sym.constint, yytext());}
{constfloat} {if (debug){System.out.println("constfloat");}
		return new Symbol(sym.constfloat, yytext());}
{constlit} {if (debug){System.out.println("constlit");}
		return new Symbol(sym.constlit, yytext());}
{comentario} {if (debug){System.out.println("coment");}
		return new Symbol(sym.coment);}

\n {System.out.print(yytext());}
[^] {;}