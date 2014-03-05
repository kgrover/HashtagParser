import java.util.*;
import java.io.*;

class HashtagParser {
	static HashMap<String, Boolean> map;
	public static void main(String[] args) {
		try{ 
			map = construct_dictionary();
			System.out.println(parse_hashtag("parsethishashtag‬"));
		}catch(FileNotFoundException fe){
			System.out.println("Error, file cannot be read.");
		}
	}
	
	public static HashMap<String, Boolean> construct_dictionary() throws FileNotFoundException{
		Scanner in = new Scanner(new File("dictionary.txt"));
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		while(in.hasNext()){
			String word = in.nextLine().toString();
			if(word.length() > 2){
				map.put(word, true);
			}
		}
		return map;
	}
	
	public static ArrayList<String> parse_hashtag(String hashtag){
		String temp_word = "";
		ArrayList<String>broken = new ArrayList<String>();
		for(int i = 0; i < hashtag.length(); i++){
			temp_word += hashtag.charAt(i);
			if(map.containsKey(temp_word)){
				System.out.println("Contains " + temp_word);
				broken.add(temp_word);
				temp_word = "";
			}
		}
		return broken;
	}
}