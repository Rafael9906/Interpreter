package edu.unbosque.compiler.lexer;
import java_cup.runtime.Symbol;
import edu.unbosque.compiler.parser.*;
      
%%
   
%class Lexer

%line
%column
%standalone
%cup    
   
%{   
    private Symbol symbol(int sym) {
        return new Symbol(sym, yyline, yycolumn);
    }
    
    private Symbol symbol(int sym, Object val) {
        return new Symbol(sym, val);
    }
    
    public void printData(String type, String text){
    	System.out.println("[" + type + ":" + text + " Line: " + yyline + " Column: " + yycolumn +"]");
    }
    
%}

Variable = [a-zA-Z_][a-zA-Z0-9_]*
Numero = \d+ 

%%

"Si"						{printData("SI",yytext()); return symbol(sym.SI);}
"Entonces"					{printData("ENTONCES",yytext()); return symbol(sym.ENTONCES);}
"Fin"						{printData("FIN",yytext()); return symbol(sym.FIN);}
"SiNo"						{printData("SINO",yytext()); return symbol(sym.SINO);}
"Repita"					{printData("REPITA",yytext()); return symbol(sym.REPITA);}
"HastaQue"					{printData("HASTAQUE",yytext()); return symbol(sym.HASTAQUE);}
"Leer"						{printData("LEER",yytext()); return symbol(sym.LEER);}
"Escribir"					{printData("ESCRIBIR",yytext()); return symbol(sym.ESCRIBIR);}
{Variable}					{printData("VARIABLE",yytext()); return symbol(sym.VARIABLE, yytext());}
{Numero}					{printData("NUMERO",yytext()); return symbol(sym.NUMBER, yytext());}
";"							{printData("PCOMMA",yytext()); return symbol(sym.PCOMMA);}
"="							{printData("EQ",yytext()); return symbol(sym.EQ);}
"-"							{printData("MINUS",yytext()); return symbol(sym.MINUS);}
"+"							{printData("PLUS",yytext()); return symbol(sym.PLUS);}
"+"							{printData("PLUS",yytext()); return symbol(sym.PLUS);}
"*"							{printData("TIMES",yytext()); return symbol(sym.TIMES);}
"/"							{printData("DIV",yytext()); return symbol(sym.DIV);}
"<"							{printData("LE",yytext()); return symbol(sym.LE);}
">"							{printData("ME",yytext()); return symbol(sym.ME);}
"=="						{printData("EQEQ",yytext()); return symbol(sym.EQEQ);}
"<="						{printData("LEQ",yytext()); return symbol(sym.LEQ);}
">="						{printData("MEQ",yytext()); return symbol(sym.MEQ);}
"("							{printData("LPAR",yytext()); return symbol(sym.LPAR);}
")"							{printData("RPAR",yytext()); return symbol(sym.RPAR);}
[\ \t\b\f\r\n]+				{ /* eat whitespace */}
"//"[^\n]*					{ /* one line comment */}
.							{ throw new Error("Illegal character <"+yytext()+">"); }