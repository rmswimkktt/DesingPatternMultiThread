package Question9_3;

import Question9_3.content.Content;
import Question9_3.content.SyncContentImpl;

public class Retriever {
	public static Content retrieve(String urlstr){
		return new SyncContentImpl(urlstr);
	}
}
