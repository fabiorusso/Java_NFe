package br.com.samuelweb.nfe.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class FileUtil {
	public static byte[] readBytesFromInputStream(final InputStream in)
			throws IOException {

		int acctualyRead = 0;
		final byte[] buffer = new byte[8192];
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((acctualyRead = in.read(buffer)) != -1) {
				baos.write(buffer, 0, acctualyRead);
			}
			return baos.toByteArray();

		} finally {
			in.close();
		}
	}

	public static String readXML(Document doc)
			throws TransformerFactoryConfigurationError, TransformerException {

		final StringWriter writer = new StringWriter();
		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();
		transformer.transform(new DOMSource(doc), new StreamResult(writer));
		String xml = writer.toString();
		return xml;

	}

	public static Document readXMLFile(File file)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		return dBuilder.parse(file);
	}

	public static Document readXMLFile(final String filename)
			throws ParserConfigurationException, SAXException, IOException {
		return readXMLFile(new File(filename));
	}

	public static Document readXMLFile(final byte[] content)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		InputStream bais = new ByteArrayInputStream(content);

		return dBuilder.parse(bais);
	}

	public static long writeToOutputStream(final OutputStream out,
			final byte[] content) throws IOException {
		try {
			out.write(content, 0, content.length);

			return content.length;
		} finally {
			out.close();
		}

	}

	public static String readFromInputStream(final InputStream in,
			final String encoding) throws IOException {

		int acctualyRead = 0;
		final byte[] buffer = new byte[FileUtilProperties.BUFFER_SIZE
				.getIntValue()];
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((acctualyRead = in.read(buffer)) != -1) {
				baos.write(buffer, 0, acctualyRead);
			}
			return baos.toString(encoding);

		} finally {
			in.close();
		}
	}
	
	public static byte[] readFromInputStream(final InputStream in) throws IOException {

		int acctualyRead = 0;
		final byte[] buffer = new byte[8192];
		try {
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    while ((acctualyRead = in.read(buffer)) != -1) {
			baos.write(buffer, 0, acctualyRead);
		    }
		    return baos.toByteArray();

		} finally {
		    in.close();
		}
	}
}
