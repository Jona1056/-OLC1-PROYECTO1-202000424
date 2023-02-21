
package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z]+
D=[0-9]+

s=[!-&]+
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






/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

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

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

/* GUION*/
( "-" ) {return new Symbol(sym.Guion, yychar, yyline, yytext());}


/* MAYOR*/
( ">" ) {return new Symbol(sym.Mayor, yychar, yyline, yytext());}



/* COMILLA SIMPLE */
( "\'" ) {return new Symbol(sym.Comilla_s, yychar, yyline, yytext());}




/* punto */
( "." ) {return new Symbol(sym.Punto, yychar, yyline, yytext());}








/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}