package org.bikram.freemarker;

import freemarker.template.Template;
import freemarker.template.Configuration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Example1 {
	
	private static String dirForTemplateLoading="/home/shilpa/personal/ide/helios_sr2_workspace/freemarker01/WebContent";
	private static String outputFile01="/home/shilpa/personal/ide/helios_sr2_workspace/freemarker01/WebContent/output01.html";


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Add the values in the datamodel
		Map datamodel = new HashMap();
		datamodel.put("pet", "Bunny");
		datamodel.put("number", new Integer((int) (Math.random()*10)));

		// Process the template using FreeMarker
		try {
			freemarkerDo(datamodel, "example1.html");
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}
	// Process a template using FreeMarker and print the results
	static void freemarkerDo(Map datamodel, String template) throws Exception
	{
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(dirForTemplateLoading));
		Template tpl = cfg.getTemplate(template);
		OutputStreamWriter output = new OutputStreamWriter(System.out);
		/*try {
		    BufferedWriter output = new BufferedWriter(new FileWriter("outputFile01"));
			tpl.process(datamodel, output);
		} catch (IOException e) {
		}*/

		tpl.process(datamodel, output);
	}


}
