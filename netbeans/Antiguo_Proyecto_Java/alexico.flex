
/* --------------------------Codigo de Usuario----------------------- */
package compilacionFormulas;

import java_cup.runtime.*;
import java.io.Reader;
      
%% //inicio de opciones
   
/* ------ Seccion de opciones y declaraciones de JFlex -------------- */  
   
/* 
    Cambiamos el nombre de la clase del analizador a Lexer
*/
%class AnalizadorLexico

/*
    Activar el contador de lineas, variable yyline
    Activar el contador de columna, variable yycolumn
*/
%line
%column   
/* 
   Activamos la compatibilidad con Java CUP para analizadores
   sintacticos(parser)
*/
%cup
   
/*
    Declaraciones

    El codigo entre %{  y %} sera copiado integramente en el 
    analizador generado.
*/
%{
    /*  Generamos un java_cup.Symbol para guardar el tipo de token 
        encontrado */
    private Symbol symbol(int type) { 
        return new Symbol(type, yyline, yycolumn);
    }
    
    /* Generamos un Symbol para el tipo de token encontrado 
       junto con su valor */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
   

/*
    Macro declaraciones
  
    Declaramos expresiones regulares que despues usaremos en las
    reglas lexicas.
*/
   
/*  Un salto de linea es un \n, \r o \r\n dependiendo del SO   */
Salto = \r|\n|\r\n
   
/* Espacio es un espacio en blanco, tabulador \t, salto de linea 
    o avance de pagina \f, normalmente son ignorados */
Espacio = {Salto} | [ \t\f]

/*Identificadores de Variables. Los nombres de las variables siempre estan escritos en Minuscula*/
Idvariable = [a-z][a-z]*

/*Identificadores de Funciones. Los nombres de las funciones siempre estan escritos en Mayusculas*/
Idfuncion = [A-Z][A-Z]* 

/*Identificadores de Predicados. Los nombres de los predicados siempre comienzan con una Mayuscula y tienen al menos una letra en Minuscula*/
Idpredicado = [A-Z][a-z][a-zA-Z]*

%% //fin de opciones
/* -------------------- Seccion de reglas lexicas ------------------ */
   
/*
   Esta seccion contiene expresiones regulares y acciones. 
   Las acciones son código en Java que se ejecutara cuando se
   encuentre una entrada valida para la expresion regular correspondiente */
   
   /* YYINITIAL es el estado inicial del analizador lexico al escanear.
      Las expresiones regulares solo serán comparadas si se encuentra
      en ese estado inicial. Es decir, cada vez que se encuentra una 
      coincidencia el scanner vuelve al estado inicial. Por lo cual se ignoran
      estados intermedios.*/
   
<YYINITIAL> {
   
    /* Regresa que el token EXISTE declarado en la clase sym fue encontrado. */
    "#"                { System.out.print(" # ");
						  return symbol(sym.EXISTE); }
    /* Regresa que el token PARATODO declarado en la clase sym fue encontrado. */
    "@"                {  System.out.print(" @ ");
                          return symbol(sym.PARATODO); }
    /* Regresa que el token NEGACION declarado en la clase sym fue encontrado. */
    "¬"|"~"            {  System.out.print(" ¬ ");
                          return symbol(sym.NEGACION); }
    /* Regresa que el token DISYUNCION declarado en la clase sym fue encontrado. */
    "|"                {  System.out.print(" or ");
                          return symbol(sym.DISYUNCION); }
    /* Regresa que el token CONJUNCION declarado en la clase sym fue encontrado. */
    "^"|"&"            {  System.out.print(" and ");
                          return symbol(sym.CONJUNCION); }
	/* Regresa que el token IMPLICACION declarado en la clase sym fue encontrado. */
    "="">"             {  System.out.print(" -> ");
                          return symbol(sym.IMPLICACION); }				  
    /* Regresa que el token PA declarado en la clase sym fue encontrado. */
    "("                {  System.out.print(" ( ");
                          return symbol(sym.PA); }
    /* Regresa que el token PC declarado en la clase sym fue encontrado. */
    ")"                {  System.out.print(" ) ");
                          return symbol(sym.PC); }
	/* Regresa que el token COMA declarado en la clase sym fue encontrado. */
    ","                {  System.out.print(" , ");
                          return symbol(sym.COMA); }
	
	/* Si se encuentra un IdVariable, se imprime, se regresa un token numero que representa un IDVAR y el valor que se obtuvo de la cadena yytext. */
    {Idvariable}      {   System.out.print(yytext()); 
                      return symbol(sym.IDVAR, new String(yytext())); }
	/* Si se encuentra un Idfuncion, se imprime, se regresa un token numero que representa un IDFUNC y el valor que se obtuvo de la cadena yytext. */
    {Idfuncion}      {   System.out.print(yytext()); 
                      return symbol(sym.IDFUNC, new String(yytext())); }
	/* Si se encuentra un Idpredicado, se imprime, se regresa un token numero que representa un IDPRED y el valor que se obtuvo de la cadena yytext. */
    {Idpredicado}      {   System.out.print(yytext()); 
                      return symbol(sym.IDPRED, new String(yytext())); }					  

    /* No hace nada si encuentra el espacio en blanco */
    {Espacio}       { /* ignora los espacios */ } 
}

/* Si el token contenido en la entrada no coincide con ninguna regla
    entonces se marca un token ilegal */
[^]                    {/* Imprime mensaje de eror, modifica la variable de "ERROR" */
						System.out.println(" Reconoce error Lexico "); 
						AnalizadorSintactico.var_error.setError(modelado.Error.tipoError.LEXICO,  new String("Caracter ilegal <"+yytext()+">"));
						/* Retorna el caracter error con la ubicacion del mismo fila, columna */
						return symbol(sym.ERROR, new String("Caracter ilegal <"+yytext()+">")); 
						}