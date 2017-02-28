/**
 * Autor: Carlos Roberto Jaimez González
 * U.E.A.: Integración de Sistemas
 * Universidad Autónoma Metropolitana
 * carlos.jaimez@gmail.com
 */

import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

//Valida un archivo XML contra un Schema XML
public class SchemaValidate implements ErrorHandler {
   
    public static void main(String[] args) throws Exception {
        //El archivo XML que se validará
        String xmlFile = args[0];
        //Creamos un Parser DOM (Xerces)
        DOMParser parser = new DOMParser();

        //Colocamos validación en "on"
        try {
            parser.setFeature
                    ("http://xml.org/sax/features/validation", true);
            parser.setFeature
                    ("http://apache.org/xml/features/validation/schema", true);
            parser.setFeature
                    ("http://apache.org/xml/features/validation/schema-full-checking", true);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Colocamos el ErrorHandler a nuestra clase SchemaValidate
        parser.setErrorHandler( new SchemaValidate() );

        //Hacemos que el parser recorra el documento XML y verifique
        //que cumple con las reglas establecidas en el Schema XML
        parser.parse(xmlFile);
    }

    //Event Handler de "Warning"
    public void warning(SAXParseException e)
            throws SAXException {
        System.err.println("Warning:  " + e);
    }

    //Event Handler de "Error"
    public void error(SAXParseException e)
            throws SAXException {
        System.err.println("Error:  " + e);
    }

    //Event Handler de "Fatal Error"
    public void fatalError(SAXParseException e)
            throws SAXException {
        System.err.println("Fatal Error:  " + e);
    }
}


