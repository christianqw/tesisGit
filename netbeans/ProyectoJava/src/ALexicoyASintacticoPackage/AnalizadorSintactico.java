
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Wed Nov 19 09:37:56 ART 2014
//----------------------------------------------------

package ALexicoyASintacticoPackage;

import java_cup.runtime.*;
import java.io.FileReader;
import formulaPackage.*;
import java.io.StringReader;
import java.util.ArrayList;
import modeladoPackge.Error_m;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Wed Nov 19 09:37:56 ART 2014
  */
public class AnalizadorSintactico extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintactico() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintactico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintactico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\024\000\002\012\002\000\002\002\004\000\002\002" +
    "\004\000\002\002\003\000\002\003\005\000\002\003\003" +
    "\000\002\004\005\000\002\004\003\000\002\005\005\000" +
    "\002\005\003\000\002\006\005\000\002\006\005\000\002" +
    "\006\004\000\002\006\005\000\002\006\003\000\002\007" +
    "\006\000\002\010\003\000\002\010\005\000\002\011\003" +
    "\000\002\011\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\047\000\016\004\001\005\001\006\001\012\001\017" +
    "\001\020\005\001\002\000\004\002\051\001\002\000\004" +
    "\002\ufffe\001\002\000\014\004\010\005\013\006\020\012" +
    "\011\017\015\001\002\000\014\002\ufff3\007\ufff3\010\ufff3" +
    "\011\ufff3\013\ufff3\001\002\000\004\015\047\001\002\000" +
    "\014\004\010\005\013\006\020\012\011\017\015\001\002" +
    "\000\014\002\ufffa\007\ufffa\010\026\011\ufffa\013\ufffa\001" +
    "\002\000\004\015\043\001\002\000\012\002\ufffc\007\024" +
    "\011\ufffc\013\ufffc\001\002\000\004\012\030\001\002\000" +
    "\014\002\ufff8\007\ufff8\010\ufff8\011\ufff8\013\ufff8\001\002" +
    "\000\006\002\000\011\022\001\002\000\014\004\010\005" +
    "\013\006\020\012\011\017\015\001\002\000\014\002\ufff5" +
    "\007\ufff5\010\ufff5\011\ufff5\013\ufff5\001\002\000\014\004" +
    "\010\005\013\006\020\012\011\017\015\001\002\000\012" +
    "\002\ufffd\007\024\011\ufffd\013\ufffd\001\002\000\014\004" +
    "\010\005\013\006\020\012\011\017\015\001\002\000\014" +
    "\002\ufffb\007\ufffb\010\026\011\ufffb\013\ufffb\001\002\000" +
    "\014\004\010\005\013\006\020\012\011\017\015\001\002" +
    "\000\014\002\ufff9\007\ufff9\010\ufff9\011\ufff9\013\ufff9\001" +
    "\002\000\006\015\031\016\033\001\002\000\006\013\uffef" +
    "\014\uffef\001\002\000\006\013\ufff1\014\ufff1\001\002\000" +
    "\004\012\040\001\002\000\006\013\036\014\035\001\002" +
    "\000\006\015\031\016\033\001\002\000\014\002\ufff2\007" +
    "\ufff2\010\ufff2\011\ufff2\013\ufff2\001\002\000\006\013\ufff0" +
    "\014\ufff0\001\002\000\006\015\031\016\033\001\002\000" +
    "\006\013\042\014\035\001\002\000\006\013\uffee\014\uffee" +
    "\001\002\000\014\004\010\005\013\006\020\012\011\017" +
    "\015\001\002\000\014\002\ufff7\007\ufff7\010\ufff7\011\ufff7" +
    "\013\ufff7\001\002\000\006\011\022\013\046\001\002\000" +
    "\014\002\ufff4\007\ufff4\010\ufff4\011\ufff4\013\ufff4\001\002" +
    "\000\014\004\010\005\013\006\020\012\011\017\015\001" +
    "\002\000\014\002\ufff6\007\ufff6\010\ufff6\011\ufff6\013\ufff6" +
    "\001\002\000\004\002\uffff\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\047\000\006\002\003\012\005\001\001\000\002\001" +
    "\001\000\002\001\001\000\014\003\016\004\013\005\011" +
    "\006\015\007\006\001\001\000\002\001\001\000\002\001" +
    "\001\000\014\003\044\004\013\005\011\006\015\007\006" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\006\020\007\006\001\001\000\002\001\001\000" +
    "\012\004\022\005\011\006\015\007\006\001\001\000\002" +
    "\001\001\000\010\005\024\006\015\007\006\001\001\000" +
    "\002\001\001\000\006\006\026\007\006\001\001\000\002" +
    "\001\001\000\006\010\033\011\031\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\011\036\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\010\040\011\031\001\001\000\002\001\001" +
    "\000\002\001\001\000\006\006\043\007\006\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\006\047\007\006\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintactico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintactico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintactico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 2;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

	/*declaramos una variable Estatica para que todos los motodos del 
	Asintactico puedan acceder a ella. */
	
	static Error_m var_error = new Error_m();
    
        public static Error_m getError(){
            return AnalizadorSintactico.var_error;
        }
        
	/* Reporte de error encontrado. */

    /**
     *
     * @param message
     * @param info
     */
    
    
  @Override
	public void report_error(String message, Object info) {
		System.out.println(" Entra a la Funcion Reporte Error ");
		StringBuilder m = new StringBuilder("Error");
        if (info instanceof java_cup.runtime.Symbol) {
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
            if (s.left >= 0) {                
                m.append(" en la linea "+(s.left+1));
                if (s.right >= 0)
                    m.append(", columna "+(s.right+1));
            }
        }
        m.append(" : " + message);
		/*Modifica la Variable estatica del Error para identificar que es Sintactico*/
		if (AnalizadorSintactico.var_error.getTipoError() == modeladoPackge.Error_m.tipoError.SINERROR) {
			AnalizadorSintactico.var_error.setError(modeladoPackge.Error_m.tipoError.SINTAXIS, m.toString());
			} 
		else {
			AnalizadorSintactico.var_error.setIdentificador(AnalizadorSintactico.var_error.getId() + m.toString());
			}
    }
   
    /* Cuando se encuentra un error de donde el sistema no puede
        recuperarse, se lanza un error fatal. Se finaliza la ejecucion
		del analizador sintactico. */
	
	public void report_fatal_error(String message, Object info) {
			System.out.println(" Entra a la Funcion al reconocer un Error Fatal ");
        	//report_error(message, info);	
    }

	/* Metodo main para garantizar la ejecucion del analizador
		lexico y sintactico, ademas que se pase como parametro la tabla
		de simbolos correspondiente. */
//	public static void main(String[] args){
//		try {
//			 /* Cada vez que se anañliza, vuelve a asignarse un sinerror  - 
//				Esta accion ademas se realiza en la primer regla del AS (acá esta por cuestiones de legibilidad)*/                  
//			AnalizadorSintactico.var_error.setError(modeladoPackge.Error.tipoError.SINERROR, " ");
//			System.out.println("-------- > LLamama al Analizador Sintactico");
//			AnalizadorSintactico asin = new AnalizadorSintactico(
//					new AnalizadorLexico( new FileReader(args[0])));
//			System.out.println("-------- > Terminó");
//			Object result = asin.parse().value;
//			System.out.println("\n ===== Resultados finales =====");
//			System.out.println(result); /*puntero a la estructura logica*/
//			System.out.print(" Valor de Satic Error al terminar: ");
//			System.out.println(AnalizadorSintactico.var_error);
//		} catch (Exception ex) {
//			System.out.println(" XXXXXXX Error Fatal Capturado XXXXXX ");
//			System.err.println(ex.toString() + "  " + ex.getMessage());
//			System.out.println(" Valor de Satic Error: ");
//			System.out.print(AnalizadorSintactico.var_error);
//        }
//    }
	
//	public static Formula EjecutarAnalizadorOriginal(String ruta){
//	try { /* Cada vez que se anañliza, vuelve a asignarse un sinerror  - 
//		Esta accion ademas se realiza en la primer regla del AS (acá esta por cuestiones de legibilidad)*/                  
//			AnalizadorSintactico.var_error.setError(modeladoPackge..Error.tipoError.SINERROR, " ");
//			System.out.println("-------- > LLamama al Analizador Sintactico");
//			AnalizadorSintactico asin = new AnalizadorSintactico(
//					new AnalizadorLexico( new FileReader(ruta)));
//			System.out.println("-------- > Terminó");
//			Formula result = (Formula) asin.parse().value;
//			System.out.println("\n ===== Resultados finales =====");
//			System.out.println(result); /*puntero a la estructura logica*/
//			System.out.print(" Valor de Satic Error al terminar: ");
//			System.out.println(AnalizadorSintactico.var_error);
//			return result;
//		} catch (Exception ex) {
//			System.out.println(" XXXXXXX Error Fatal Capturado XXXXXX ");
//			System.err.println(ex.toString() + "  " + ex.getMessage());
//			System.out.println(" Valor de Satic Error: ");
//			System.out.print(AnalizadorSintactico.var_error);
//			return null;
//        }
//	}
        
        public static Formula EjecutarAnalizador(String s_formula){
        /* 
        Cada vez que se anañliza una nueva f, vuelve a asignarse un sinerror  - 
	Esta accion ademas se realiza en la primer regla del AS (acá esta por cuestiones de legibilidad)
        */ 
	try {                  
            AnalizadorSintactico.var_error.setError(modeladoPackge.Error_m.tipoError.SINERROR, " ");
                System.out.println("-------- > LLamama al Analizador Sintactico");
                System.out.println("con la siguiente formula: ");
                System.out.println(s_formula);
                
                //String saux = " (Escirculo(a)|Escirculo(c))  ";
            StringReader _fAux = new StringReader(s_formula);
            AnalizadorSintactico asin = new AnalizadorSintactico(new AnalizadorLexico( _fAux ));
                System.out.println("-------- > Terminó");
            Formula result = (Formula) asin.parse().value;
                System.out.println("\n ===== Resultados finales =====");
                System.out.println(result); /*puntero a la estructura logica*/
                System.out.print(" Valor de Satic Error al terminar: ");
                System.out.println(AnalizadorSintactico.var_error);
            return result;
	} catch (Exception ex) {
		System.out.println(" XXXXXXX Error Fatal Capturado XXXXXX ");
		System.err.println(ex.toString() + "  " + ex.getMessage());
		System.out.println(" Valor de Satic Error: ");
		System.out.print(AnalizadorSintactico.var_error);
            return null;
        }
	}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintactico$actions {

 
		/*
		 En este bloque pueden declararse variables, funciones, etc. todas de tipo
		estático ya que no existen objetos accesibles mediante los que referenciar 
		componentes no estáticos. 
		Todo lo que se declare en este bloque será accesible a las acciones 
		semánticas.
		*/
		
	
  private final AnalizadorSintactico parser;

  /** Constructor */
  CUP$AnalizadorSintactico$actions(AnalizadorSintactico parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintactico$do_action(
    int                        CUP$AnalizadorSintactico$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintactico$parser,
    java.util.Stack            CUP$AnalizadorSintactico$stack,
    int                        CUP$AnalizadorSintactico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintactico$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintactico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // term ::= IDFUNC PA listaTerm PC 
            {
              Termino RESULT =null;
		int idfleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)).left;
		int idfright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)).right;
		String idf = (String)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)).value;
		int lisleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int lisright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		ArrayList<Termino> lis = (ArrayList<Termino>)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		 
								RESULT = new Funcion( idf, lis);
							
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("term",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // term ::= IDVAR 
            {
              Termino RESULT =null;
		int idvleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int idvright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		String idv = (String)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		
					RESULT = new Variable(idv);
					
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("term",7, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // listaTerm ::= listaTerm COMA term 
            {
              ArrayList<Termino> RESULT =null;
		int lisleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).left;
		int lisright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).right;
		ArrayList<Termino> lis = (ArrayList<Termino>)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Termino t = (Termino)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 
								lis.add(t);
								RESULT = lis;
							
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("listaTerm",6, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // listaTerm ::= term 
            {
              ArrayList<Termino> RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Termino t = (Termino)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 /*RESULT puede ser utilizado como una variable auxiliar comun dentro del
						cogo Java*/
						RESULT = new ArrayList<Termino> () ;
						RESULT.add(t);
					
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("listaTerm",6, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // pred ::= IDPRED PA listaTerm PC 
            {
              Formula RESULT =null;
		int idpleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)).left;
		int idpright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)).right;
		String idp = (String)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).value;
		int lisleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int lisright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		ArrayList<Termino> lis = (ArrayList<Termino>)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Object c = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 
								RESULT = new Predicado(idp, lis);
							
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("pred",5, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-3)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // factor ::= pred 
            {
              Formula RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula p = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 
				RESULT = p;
				
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("factor",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // factor ::= PA cond PC 
            {
              Formula RESULT =null;
		int xleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int xright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		Formula x = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		 /*Las reglas de la gramatica generan sobre la estructura resultante
							el orden de precedencia de las formulas involucradas por lo que no 
							es necesario incorporar los parentesis ("(" ")") dentro de la 
							estructura logica. */
								RESULT = x;
							
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("factor",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // factor ::= NEGACION factor 
            {
              Formula RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int nright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 
								RESULT = new Negacion(f);
							
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("factor",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // factor ::= EXISTE IDVAR factor 
            {
              Formula RESULT =null;
		int idvleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int idvright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		String idv = (String)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 
								RESULT = new Existe( f, idv);
								
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("factor",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // factor ::= PARATODO IDVAR factor 
            {
              Formula RESULT =null;
		int idvleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int idvright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		String idv = (String)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 
								RESULT = new ParaTodo( f, idv);
								
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("factor",4, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // conj ::= factor 
            {
              Formula RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 /* factor se llama a una unidad cuantificada o negada;*/
					RESULT = f;
					
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("conj",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // conj ::= conj CONJUNCION factor 
            {
              Formula RESULT =null;
		int cjleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).left;
		int cjright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).right;
		Formula cj = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula f = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 
								RESULT = new Conjuncion(cj, f);
								
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("conj",3, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // disy ::= conj 
            {
              Formula RESULT =null;
		int cjleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int cjright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula cj = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		
			RESULT = cj;
				
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("disy",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // disy ::= disy DISYUNCION conj 
            {
              Formula RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).right;
		Formula d = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).value;
		int cjleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int cjright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula cj = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		
								RESULT = new Disyuncion (d, cj);
								
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("disy",2, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // cond ::= disy 
            {
              Formula RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula d = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		
				RESULT = d;
				
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("cond",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // cond ::= cond IMPLICACION disy 
            {
              Formula RESULT =null;
		int conleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).left;
		int conright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).right;
		Formula con = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)).value;
		int dleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula d = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		 
								RESULT = new Condicional(con, d);
								
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("cond",1, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // comienzo ::= ERROR 
            {
              Formula RESULT =null;
		 
				System.out.println(" -----  ERROR DE LA PRIMERA PRODUCCION  ---- ");
				
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("comienzo",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // $START ::= comienzo EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).right;
		Formula start_val = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintactico$parser.done_parsing();
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // comienzo ::= NT$0 cond 
            {
              Formula RESULT =null;
              // propagate RESULT from NT$0
                RESULT = (Formula) ((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)).value;
		int solleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).left;
		int solright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()).right;
		Formula sol = (Formula)((java_cup.runtime.Symbol) CUP$AnalizadorSintactico$stack.peek()).value;
		
							RESULT = sol; System.out.println("llega a terminar todo");
							
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("comienzo",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.elementAt(CUP$AnalizadorSintactico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // NT$0 ::= 
            {
              Formula RESULT =null;
   /* Cada vez que se anañliza, vuelve a asignarse un sinerror   */                  
				AnalizadorSintactico.var_error.setError(modeladoPackge.Error_m.tipoError.SINERROR, " ");
				
              CUP$AnalizadorSintactico$result = parser.getSymbolFactory().newSymbol("NT$0",8, ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintactico$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintactico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

