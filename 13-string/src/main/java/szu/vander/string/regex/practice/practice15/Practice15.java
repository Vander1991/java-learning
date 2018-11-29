package szu.vander.string.regex.practice.practice15;

//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}

import java.util.regex.*;
import szu.vander.util.*;

/**
 * 
* @author      : Vander
* @date        : 2018-11-29
* @description : 修改JGep.java类，使其接受模式标志参数
 */
public class Practice15 {
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("Usage: java JGrep file regex");
			System.exit(0);
		}
		Pattern p = Pattern.compile(args[1], Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
		// Iterate through the lines of the input file:
		int index = 0;
		String str = TextFile.read(args[0]);
		Matcher m = p.matcher(str);
		while (m.find()) {
			System.out.println(index++ + ": " + m.group() + ": " + m.start());
		}
	}
}


