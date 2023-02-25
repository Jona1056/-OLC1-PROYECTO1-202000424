
package codigo;
import Arbol.main;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_$]+
D=[0-9]+
c=[\"]
S=[!-}]+
J=[!-/ :-` {-}]+


STR = "\"" [^\"\n]+ "\""
espacio=[ ,\t,\r,\n]+
%{
     private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%







/* CONJUNTO*/
( "CONJ" ) {return new Symbol(sym.Conjunto, yychar, yyline, yytext());}

/* PORCENTAJE */
( "%" ) {return new Symbol(sym.Porcentaje, yychar, yyline, yytext());}

/* DOS PUNTOS */
( ":" ) {return new Symbol(sym.D_puntos, yychar, yyline, yytext());}

/* punto y coma*/
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}



/* GUION*/
( "-" ) {return new Symbol(sym.Guion, yychar, yyline, yytext());}


/* MAYOR*/
( ">" ) {return new Symbol(sym.Mayor, yychar, yyline, yytext());}



/* COMILLA SIMPLE */
( "\'" ) {return new Symbol(sym.Comilla_s, yychar, yyline, yytext());}


/* PUNTO*/
( "." ) {return new Symbol(sym.PUNTO1, yychar, yyline, yytext());}


/*KLEENE*/
( "*" ) {return new Symbol(sym.KLEENE, yychar, yyline, yytext());}

/*INTEROGGACION*/
( "?" ) {return new Symbol(sym.Interrogacion, yychar, yyline, yytext());}

/* OR*/
( "|" ) {return new Symbol(sym.OR, yychar, yyline, yytext());}

/* SUMA*/
( "+" ) {return new Symbol(sym.SUMA, yychar, yyline, yytext());}

( "\"" ) {return new Symbol(sym.COMILLAS, yychar, yyline, yytext());}


/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}
"<!"(.|\n)*?"!>" {/*Ignore*/}
/* IDENTIFICADOR */

{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

{L}"~"{L} {return new Symbol(sym.CON, yychar, yyline, yytext());}
{J}"~"{J} {return new Symbol(sym.CON, yychar, yyline, yytext());}
{D}"~"{D} {return new Symbol(sym.CON, yychar, yyline, yytext());}
{c}({S}|{L}){c} {return new Symbol(sym.Oracion, yychar, yyline, yytext());}
({L})("\,"({L}|{D}))* {return new Symbol(sym.CON, yychar, yyline, yytext());}
({D})("\,"({D}|{L}))* {return new Symbol(sym.CON, yychar, yyline, yytext());}
"\"" [^\"\n]+ "\"" {return new Symbol(sym.Oracion2, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
