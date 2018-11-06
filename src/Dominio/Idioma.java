
package Dominio;

import java.io.IOException;
import java.util.Properties;

public class Idioma extends Properties{
    
    private static final long serialVersionUID = 1L;
    private String idioma;
    
    public Idioma(String idioma){
    	this.idioma = idioma;
        //Modificar si quieres añadir mas idiomas
        //Cambia el nombre de los ficheros o añade los necesarios
    	switch(idioma){
	    	case "Español":
                    getProperties("spain.properties");
                    break;
	    	case "Ingles":
                    getProperties("english.properties");
                    break;
	    	default:
                    getProperties("spain.properties");
	   	}

    }
    
    public String getIdioma(){
        return idioma;
    }
    
    private void getProperties(String idioma) {
        try {
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
        
        }
   }
}
