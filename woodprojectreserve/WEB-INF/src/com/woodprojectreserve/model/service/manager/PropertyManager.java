package com.woodprojectreserve.model.service.manager;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.woodprojectreserve.model.buisness.exception.PropertyFileNotFoundException;

/** <h1>PropertyManager</h1>
 * <br>
 * <code>PropertyManager</code> class implements a Service Property Manager 
 * <br><br>
 * 
 * @version - 7.27.2020
 * @author Christopher Culver
 */
public class PropertyManager extends DefaultHandler {

	private static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema"; 
	private static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	
	private static Properties properties;
	private StringBuffer stringbuffer;
	private String key;
	private String value;
	
	/** <h1>loadProperties</h1>
	 * <br>
	 * Loads the property XML file with in given properties directory and associated XSD schema
	 * <br><br>
	 * @param propertyFileLocation <code>String</code> directory representing location 
	 * 							   of the application.property file
	 * @throws PropertyFileNotFoundException Error thrown if properties file loading 
	 * 										 issues occur
	 */
	public void loadProperties(String propertyFileLocation) throws PropertyFileNotFoundException	{
		
		try {
			
			stringbuffer = new StringBuffer();
			
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			
			saxParserFactory.setNamespaceAware(true);
			saxParserFactory.setValidating(true);
			
			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA); 
			saxParser.setProperty(JAXP_SCHEMA_SOURCE, new File (propertyFileLocation + "ApplicationProperties.xsd"));
			
			File file = new File (propertyFileLocation + "application.properties.xml");
			
			saxParser.parse(file, this);
			
			System.out.println("");
			
		} catch (SAXParseException saxParseException) {
			
			System.err.println("\n** Parsing error, line " + saxParseException.getLineNumber() + ", uri " + saxParseException.getSystemId());
			System.err.println("   " + saxParseException.getMessage() );
		
			Exception exception = saxParseException;
			
			if (saxParseException.getException() != null) {
				exception = saxParseException.getException();
			}
			
			System.out.println(exception);
		
		} catch (SAXException saxException) {

			Exception exception = saxException;
			
			if (saxException.getException() != null){
				exception = saxException.getException();
			}
			
			System.out.println(exception);
		
		} catch (ParserConfigurationException parserConfigurationException) {
			System.out.println(parserConfigurationException);
		} catch (IOException ioException) {
			System.out.println(ioException);
		}
	
	}
	
	@Override
	public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
		
		stringbuffer.setLength(0);
		
		switch (qualifiedName) {
			case "applicationproperties":
				properties = new Properties();
				break;
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
		
		switch (qualifiedName) {
			case "key":
				key = stringbuffer.toString().trim();
				break;
			case "value":
				value = stringbuffer.toString().trim();
				break;
			case "database":
			case "service":
			case "sqlstatement":
			case "hqlstatement":
			case "server":
				properties.setProperty(key, value);
				break;
		}
		
		stringbuffer.setLength(0);
	}

	@Override
	public void characters(char[] character, int start, int length) throws SAXException {
		stringbuffer.append(character, start, length);
	}

	@Override
	public void error(SAXParseException saxParseException) throws SAXParseException {
		throw saxParseException;
	}

	@Override
	public void warning(SAXParseException saxParseException) throws SAXParseException {
		System.err.println("** Warning, line " + saxParseException.getLineNumber() + ", uri " + saxParseException.getSystemId());
		System.err.println("   " + saxParseException.getMessage());
	}
	
	/** <h1>getPropertyValue</h1>
	 * 
	 * Searches for the property with the specified key in this property list.
	 * If the key is not found in this property list, the default property 
	 * list, and its defaults, recursively, are then checked. The method 
	 * returns null if the property is not found.
	 * 
	 * @param key The property key
	 * @return The value in this property list with the specified key value
	 */
	public static String getPropertyValue (String key) {
    	return properties.getProperty(key);
    }
	
}

