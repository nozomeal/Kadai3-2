package snakecamel;
import java.util.Arrays;
import java.util.ArrayList;

public class SnakeCamelUtil {

	public static String snakeToCamelcase(String snake_case) {
		String[] words = snake_case.split("_");
		StringBuilder sb = new StringBuilder();
		System.out.println(snake_case);
		//配列の中が""であった場合
		for(int i=0;i<words.length;i++) {
			System.out.println("words["+i+"]："+words[i]);
			if(Arrays.asList(words[i]).contains("")) {
				//配列の中身が""
				System.out.println(Arrays.asList(words[i]).contains(""));
				//配列の中が"のものを削除するメソッドを実行"
				words = remove(words, "");
				//System.out.println("words["+i+"]置き換え後："+words[i]);
			}
		}
		System.out.println("結果");
		for(int i=0;i<words.length;i++) {
			System.out.println("words["+i+"]："+words[i]);
		}
		//lenght()-1 ->lenght()に修正
		for (int i = 0; i < words.length; i++) {	
			sb.append(capitalize(words[i]));
		}
		return new String(sb);
	}
	
	//配列を削除するためのメソッド
	private static String[] remove(String[] target, String removeStr) {
	    ArrayList<String> temp = new ArrayList<>(Arrays.asList(target));
	    temp.remove(removeStr);
	    return temp.toArray(new String[0]);
	}
	
	 
	public static String camelToSnakecase(String camel_case) {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < camel_case.length(); i++) {
			char c = camel_case.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(camel_case.substring(j, i));
				if (sb.length() > 0) {
					sb.append("_");
				}
				String C = String.valueOf(c);
				sb.append(uncapitalize(C));
				
				
				j = i;
			}
		}
		sb.append(camel_case.substring(j+1));
		return new String(sb);
	}
	
	static String capitalize(String s) {
		char first = s.charAt(0);
		char upperFirst = Character.toUpperCase(first);
		String rest = s.substring(1);
		return upperFirst + rest;
	}

	static String uncapitalize(String s) {
		char first = s.charAt(0);
		char lowerFirst = Character.toLowerCase(first);
		String rest = s.substring(1);
		return lowerFirst + rest;
	}
	
}
