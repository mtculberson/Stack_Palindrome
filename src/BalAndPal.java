import java.util.Stack;

public class BalAndPal {
	public static void main(String[] args) {
		//String for balance testing
		String a = "{{{{}}}}";
		String b = "{{{{}}}";
		String c = "{}{}{}{}{}{}{}{}";
		String d = "}{{{}}}";
		
		//Strings for palindrome testing
		String e = "A man, A plan, A canal: Panama";
		String f = "Madam I'm Adam";
		String g = "tacocat";
		String h = "this is not a palindrome";
		
		System.out.println(isBalanced(a));
		System.out.println(isBalanced(b));
		System.out.println(isBalanced(c));
		System.out.println(isBalanced(d));
		System.out.println();
		
		System.out.println(isPal(e));
		System.out.println(isPal(f));
		System.out.println(isPal(g));
		System.out.println(isPal(h));
		System.out.println();
		
		System.out.println(isPalLettersOnly(e));
		System.out.println(isPalLettersOnly(f));
		System.out.println(isPalLettersOnly(g));
		System.out.println(isPalLettersOnly(h));
	}
	
	public static boolean isBalanced(String toTest) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i< toTest.length(); i++){
			char ch = toTest.charAt(i);
			
			if(ch == '}' && stack.isEmpty()){
				return false;
			}else if(ch == '{'){
				stack.push(ch);
			}else{
				stack.pop();
			}
		}
		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
		
	}

	public static boolean isPal(String toTest) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i< toTest.length(); i++){
			char ch = toTest.charAt(i);
			stack.push(ch);
		}
		
		for(int i = 0; i< toTest.length(); i++){
			char ch = toTest.charAt(i);
			if(stack.peek() == ch){
				stack.pop();
			}else{
				return false;
			}
		}
		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isPalLettersOnly(String toTest) {
		toTest = toTest.toLowerCase();
		toTest = toTest.replaceAll("[^a-zA-Z]", "");
		
			
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i< toTest.length(); i++){
			char ch = toTest.charAt(i);
			stack.push(ch);
		}
		
		for(int i = 0; i< toTest.length(); i++){
			char ch = toTest.charAt(i);
			if(stack.peek() == ch){
				stack.pop();
			}else{
				return false;
			}
		}
		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}