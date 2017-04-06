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
" - " {if (debug){System.out.print("menos");}
		return new Symbol(sym.menos);}
" + " {if (debug){System.out.print("mas");}
		return new Symbol(sym.mas);}
" * " {if (debug){System.out.print("mul");}
		return new Symbol(sym.mul);}
" / " {if (debug){System.out.print("div");}
		return new Symbol(sym.div);}
" % " {if (debug){System.out.print("rest");}
		return new Symbol(sym.rest);}
"(" {if (debug){System.out.print("para");}
		return new Symbol(sym.para);}
")" {if (debug){System.out.print("parc");}
		return new Symbol(sym.parc);}
";" {if (debug){System.out.print("puntc");}
		return new Symbol(sym.puntc);}
"," {if (debug){System.out.print("coma");}
		return new Symbol(sym.coma);}
"=" {if (debug){System.out.print("igual");}
		return new Symbol(sym.igual);}
"{" {if (debug){System.out.print("llava");}
		return new Symbol(sym.llava);}
"}" {if (debug){System.out.print("llavc");}
		return new Symbol(sym.llavc);}
"void" {if (debug){System.out.print("voidd");}
		return new Symbol(sym.voidd);}
"int" {if (debug){System.out.print("intt");}
		return new Symbol(sym.intt);}
"float" {if (debug){System.out.print("floatt");}
		return new Symbol(sym.floatt);}
"return" {if (debug){System.out.print("returnn");}
		return new Symbol(sym.returnn);}
"if" {if (debug){System.out.print("if");}
		return new Symbol(sym.iff);}
"then" {if (debug){System.out.print("then");}
		return new Symbol(sym.thenn);}
"else" {if (debug){System.out.print("else");}
		return new Symbol(sym.elsee);}
"for" {if (debug){System.out.print("for");}
		return new Symbol(sym.forr);}
"while" {if (debug){System.out.print("while");}
		return new Symbol(sym.whilee);}
"until" {if (debug){System.out.print("until");}
		return new Symbol(sym.untill);}
"do" {if (debug){System.out.print("do");}
		return new Symbol(sym.doo);}
"==" {if (debug){System.out.print("equals");}
		return new Symbol(sym.equals);}
"<" {if (debug){System.out.print("less");}
		return new Symbol(sym.less);}
">" {if (debug){System.out.print("more");}
		return new Symbol(sym.more);}
">=" {if (debug){System.out.print("moreq");}
		return new Symbol(sym.moreq);}
"<=" {if (debug){System.out.print("lesseq");}
		return new Symbol(sym.lesseq);}
"not" {if (debug){System.out.print("not");}
		return new Symbol(sym.nott);}
"or" {if (debug){System.out.print("or");}
		return new Symbol(sym.orr);}
"and" {if (debug){System.out.print("and");}
		return new Symbol(sym.andd);}
"." {if (debug){System.out.print(".");}
		return new Symbol(sym.punto);}
"struct" {if (debug){System.out.print("struct");}
		return new Symbol(sym.struct);}
"[" {if (debug){System.out.print("corcha");}
		return new Symbol(sym.corcha);}
"]" {if (debug){System.out.print("corchc");}
		return new Symbol(sym.corchc);}
{ident} {if(debug){System.out.print("ident");}
		return new Symbol(sym.ident, yytext());}
{constint} {if (debug){System.out.print("constint");}
		return new Symbol(sym.constint, yytext());}
{constfloat} {if (debug){System.out.print("constfloat");}
		return new Symbol(sym.constfloat, yytext());}
{constlit} {if (debug){System.out.print("constlit");}
		return new Symbol(sym.constlit, yytext());}
{comentario} {if (debug){System.out.print("coment");}
		return new Symbol(sym.coment);}

" " {if (debug){System.out.print(" ");};}
\n {if (debug){System.out.println();}}
\t {if (debug){System.out.print("\t");}}
\r {if (debug){System.out.print("\r");}}
[^" "\n\t\r] {if (debug){System.out.print("ERROR");}
		System.out.print("Detectado un error... continuando");
		//return new Symbol(sym.error);
		}