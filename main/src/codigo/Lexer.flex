
package codigo;
import Arbol.main;
import java_cup.runtime.Symbol;
%%
%class Lexer

%line 
%char 
%cup 
%unicode
%ignorecase

L=[a-zA-Z_$]+
D=[0-9]+
c=[\"]+

S=[!-}]
J=[ -/:-@\[-`{-}]
n=("\\\"")
ñ=("\\\'")
ene = ("\\n")
%init{ 
    yyline = 1; 
    yychar = 1; 
%init}

STR = "\"" [^\"\n]+ "\""

espacio=[ ,\t,\r]+
ENTRADA =  [^!]

%%
\n {yychar=1;}
{espacio} {}
"//".* {}
"<!" {ENTRADA}* "!>" {}

"CONJ" {return new Symbol(sym.Conjunto,yyline,yychar, yytext());} 
{ene} {return new Symbol(sym.Com2,yyline,yychar, yytext());} 
{ñ} {return new Symbol(sym.Com1,yyline,yychar, yytext());} 
{n} {return new Symbol(sym.Com3,yyline,yychar, yytext());} 
"%" {return new Symbol(sym.Porcentaje,yyline,yychar, yytext());} 
":" {return new Symbol(sym.D_puntos,yyline,yychar, yytext());} 
";" {return new Symbol(sym.P_coma,yyline,yychar, yytext());} 
"{" {return new Symbol(sym.Llave_a,yyline,yychar, yytext());} 
"}" {return new Symbol(sym.Llave_c,yyline,yychar, yytext());} 
"?" {return new Symbol(sym.Interrogacion,yyline,yychar, yytext());} 
"-" {return new Symbol(sym.Guion,yyline,yychar, yytext());} 
">" {return new Symbol(sym.Mayor,yyline,yychar, yytext());} 
"\\" {return new Symbol(sym.Barra,yyline,yychar, yytext());} 
"'" {return new Symbol(sym.Comilla_s,yyline,yychar, yytext());} 

"." {return new Symbol(sym.PUNTO1,yyline,yychar, yytext());} 
"*" {return new Symbol(sym.KLEENE,yyline,yychar, yytext());} 
"|" {return new Symbol(sym.OR,yyline,yychar, yytext());} 
"+" {return new Symbol(sym.SUMA,yyline,yychar, yytext());} 
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
{espacio}*{L}{espacio}*"~"{espacio}*{L} {return new Symbol(sym.CON1, yychar, yyline, yytext());}
{espacio}*{J}{espacio}*"~"{espacio}*{J} {return new Symbol(sym.CON1, yychar, yyline, yytext());}
{espacio}*{D}{espacio}*"~"{espacio}*{D} {return new Symbol(sym.CON1, yychar, yyline, yytext());}
{c}({S}|{L}|{n}|{ñ}|[^\"\n]){c} {return new Symbol(sym.Oracion, yychar, yyline, yytext());}
"\""([^\"\n]|{n}|{ñ})+ "\"" {return new Symbol(sym.Oracion2, yychar, yyline, yytext());}
({L}|{J} {espacio}*)("\,"{espacio}* ({L}|{D}|{J}) {espacio}*)+ {return new Symbol(sym.CON, yychar, yyline, yytext());}
({D}|{J} {espacio}*)("\,"{espacio}* ({D}|{L}|{J}) {espacio}*)+ {return new Symbol(sym.CON, yychar, yyline, yytext());}







  


 . {  
   Errores.addErrores(yytext().toString(),yyline,yychar,"LEXICO",yytext().toString());

System.out.println("Este es un error lexico: "+yytext() + ", en la linea: "+yyline+", en la columna: "+yychar);}
