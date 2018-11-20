package szu.vander.container.stack;

public class StackTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		// fleas-跳蚤
		for (String s : "My dog has fleas".split(" "))
			stack.push(s);
		while (!stack.empty())
			System.out.print(stack.pop() + " ");
	}
} /*
	 * Output: fleas has dog My
	 */// :~
