package marathon;

import java.util.LinkedHashSet;
import java.util.Set;

public class Setprogramassignment {

	public static void main(String[] args) {
String str="google";
 char[] charArray = str.toCharArray();
Set<Character> unique=new LinkedHashSet<Character>();
for (Character i : charArray) {
	unique.add(i);
	
}
System.out.println("The Unique Letters Are : " +unique);

	}

}
