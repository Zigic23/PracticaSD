package yylexmain;
import java_cup.runtime.*;
%%
%class AnalizadorLexico
%unicode
%cup
%{
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
{ident} {return new Symbol(sym.ident, yytext());}
{constint} {return new Symbol(sym.constint, yytext());}
{constfloat} {return new Symbol(sym.constfloat, yytext());}
{constlit} {return new Symbol(sym.constlit, yytext());}
{comentario} {return new Symbol(sym.coment);}
" - " {return new Symbol(sym.menos);}
" + " {return new Symbol(sym.mas);}
" * " {return new Symbol(sym.mul);}
" / " {return new Symbol(sym.div);}
" % " {return new Symbol(sym.rest);}
"(" {return new Symbol(sym.para);}
")" {return new Symbol(sym.parc);}
";" {return new Symbol(sym.puntc);}
"," {return new Symbol(sym.coma);}
"=" {return new Symbol(sym.igual);}
"{" {return new Symbol(sym.llava);}
"}" {return new Symbol(sym.llavc);}
"void" {return new Symbol(sym.voidd);}
"int" {return new Symbol(sym.intt);}
"float" {return new Symbol(sym.floatt);}
"return" {return new Symbol(sym.returnn);}

\n {System.out.print(yytext());}
[^] {;}