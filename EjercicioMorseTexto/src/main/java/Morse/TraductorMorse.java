package Morse;

/**
 *
 * @author PC
 */
public class TraductorMorse {
	// Declaramos la matriz con las letras y números junto a su código morse
    String [][] matriz = {{"A",".-"},{"B","-..."},{"C","-.-."},{"D","-.."},{"E","."},{"F","..-."},{"G","--."},{"H","...."},{"I",".."},{"J",".---"},{"K","-.-"},{"L",".-.."},{"M","--"},
    		{"N","-."},{"O","---"},{"P",".--."},{"Q","--.-"},{"R",".-."},{"S","..."},{"T","-"},{"U","..-"},{"V","...-"},{"W",".--"},{"X","-..-"},{"Y","-.--"},{"Z","--.."},{"1",".----"},{"2","..---"},{"3","...--"},
    		{"4","....-"},{"5","....."},{"6","-...."},{"7","--..."},{"8","---.."},{"9","----."},{"0","-----"}}; 
    
 // ################################################################ TEXTO A MORSE ############################################################################
    
    /* Recibimos como parámetro una oración, la cual convertimos siempre a mayúsculas para evitar problemas de compatibilidad con la matriz.
     * Luego dividimos la oración en palabras y mandamos cada palabra como argumento a la función Palabra y nos regresa la misma palabra en código morse.
     * A la vez, concatenamos las palabras y les agregamos 3 espacios antes de cada palabra, excepto la primer palabra (i == 0)
     * Por último, retornamos toda la oración ya traducida a morse.
     * */
    public String TraducirAMorse(String c) {
    	String cadena = c.toUpperCase();
    	String[] palabras = cadena.split(" ");
    	cadena = "";
    	for(int i = 0; i < palabras.length; i++) {
    		if(i != 0) {
    			cadena += "   ";
    		}
    		cadena += PalabraAMorse(palabras[i]);
    	}
    	
    	if(cadena.equals("")) { //En caso de no encontrar un código morse a lo ingresado, regresamos un mensaje
    		cadena = "No se encontró traducción para dicho texto...";    		
    	}
    	
    	return cadena;
    }
    
    /* Recibimos como parámetro una palabra, la cual dividimos en letras y se envían como argumento a la función Letra.
     * La variable p guarda las letras ya convertidas a código morse y les agrega un espacio antes de cada letra, excepto en la primera (i == 0)
     * Retornamos la palabra ya traducida a código morse
     * */
    public String PalabraAMorse(String palabra){
        String[] letras = palabra.split("");
        String p = "";
        for(int i = 0; i < letras.length; i++) {
        	if(i != 0) {
        		p += " ";        		
        	}
        	p += LetraAMorse(letras[i]);
        }
    	return p;
    }
    
    /* Recibimos como parámetro una letra, la cual la comparamos contra nuestra matriz de códigos morse.
     * Luego asignamos su valor morse a una variable l, la cual retornamos a la llamada de la función.
     * En caso de que el parámetro recibido no corresponda a un código guardado en la matriz, se devuelve una cadena vacía.
     * */
    public String LetraAMorse(String letra){
    	String l = "";
    	for(int i = 0; i < matriz.length; i++) {
    		if(letra.equals(matriz[i][0])) {
    			l = matriz[i][1];
    		}
    	}
    	return l;
    }
    
    // ################################################################ MORSE A TEXTO ############################################################################
    
    /* Recibimos como parámetro una oración en código morse.
     * Luego dividimos la oración en palabras y mandamos cada palabra como argumento a la función PalabraATexto y nos regresa la misma palabra en texto.
     * A la vez, concatenamos las palabras y les agregamos un espacio antes de cada palabra, excepto la primer palabra (i == 0)
     * Por último, retornamos toda la oración ya traducida a texto.
     * */
    public String TraducirATexto(String c) {
    	String[] palabras = c.split("   ");
    	String cadena = "";
    	for(int i = 0; i < palabras.length; i++) {
    		if(i != 0) {
    			cadena += " ";
    		}
    		cadena += PalabraATexto(palabras[i]);
    	}
    	
    	if(cadena.equals("")) { //En caso de no encontrar una traducción, regresamos un mensaje
    		cadena = "No se encontró traducción para dicho código...";
    	}
    	return cadena;
    }
    
    /* Recibimos como parámetro una palabra en código morse, la cual dividimos en letras y se envían como argumento a la función LetraATexto.
     * La variable p guarda los códigos ya convertidos a texto, luego retornamos la palabra en código morse ya traducida a texto
     * */
    public String PalabraATexto(String palabra){
        String[] letras = palabra.split(" ");
        String p = "";
        for(int i = 0; i < letras.length; i++) {
        	p += LetraATexto(letras[i]);
        }
    	return p;
    }
    
    /* Recibimos como parámetro el código morse de una letra, la cual la comparamos contra nuestra matriz de códigos morse y texto.
     * Luego asignamos su valor en texto a una variable l, la cual retornamos a la llamada de la función.
     * En caso de que el parámetro recibido no corresponda a una letra guardada en la matriz, se devuelve una cadena vacía.
     * */
    public String LetraATexto(String letra){
    	String l = "";
    	for(int i = 0; i < matriz.length; i++) {
    		if(letra.equals(matriz[i][1])) {
    			l = matriz[i][0];
    		}
    	}
    	return l;
    }
}
