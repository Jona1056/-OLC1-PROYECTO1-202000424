
package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z]+
D=[0-9]+
c=[\"]
 


espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
"\n" {lexeme=yytext(); return Linea;}
"CONJ" {lexeme=yytext(); return Conjunto;}
"%" {lexeme=yytext(); return Porcentaje;}
":" {lexeme=yytext(); return D_puntos;}
";" {lexeme=yytext(); return P_coma;}
"{" {lexeme=yytext(); return Llave_a;}
"}" {lexeme=yytext(); return Llave_c;}
"\"" {lexeme=yytext(); return Comillas;}
"-" {lexeme=yytext(); return Guion;}
">" {lexeme=yytext(); return Mayor;}
"," {lexeme=yytext(); return Coma;}
"'" {lexeme=yytext(); return Comilla_s;}
"." {lexeme=yytext(); return Punto;}
"~" {lexeme=yytext(); return Separador;}


{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"<!"(.|\n)"!>" {/*Ignore*/}
"<!"(.|\n)*?"!>" {/*Ignore*/}
{c}.+{c} {lexeme=yytext(); return Oracion;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}

 . {return ERROR;}