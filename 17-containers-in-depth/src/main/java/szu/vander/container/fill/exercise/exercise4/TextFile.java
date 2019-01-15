package szu.vander.container.fill.exercise.exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
* @author     : Vander
* @date       : 2019-01-13
* @description: 
*/
public class TextFile extends ArrayList<String>{

	private static final long serialVersionUID = 1L;

	
	public TextFile(String fileName, String regex) {
		super(split(regex, read(fileName)));
	}
	
	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	public static List<String> split(String regex, String content) {
		Pattern pattern = Pattern.compile(regex);
		return Arrays.asList(pattern.split(content));
	}
	
}
