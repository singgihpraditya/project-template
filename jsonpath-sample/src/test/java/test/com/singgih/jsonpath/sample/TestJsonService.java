package test.com.singgih.jsonpath.sample;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.singgih.jsonpath.sample.JsonService;

public class TestJsonService {
	Logger log = Logger.getLogger("com.singgih.jsonpath");

	@Test
	public void testParseJson() {
		String path = "e:/json.txt";
		String jxpath = "$..book[?(@.category == 'fiction')].author";
		JsonService jsonService = new JsonService();
		String json = jsonService.readFile(path);
		log.debug("json string : "+json);
		Object jsonObject = jsonService.parseJson(json, jxpath);
//		System.out.println(jsonObject.getClass().getName());
		if (jsonObject instanceof net.minidev.json.JSONArray) {
			List<String> list = (List<String>) jsonObject;
			for (Object basicObject : list) {
				if(basicObject instanceof java.util.LinkedHashMap){
					LinkedHashMap<String, Object> hashMap = (LinkedHashMap<String, Object>) basicObject;
					for(String key : hashMap.keySet()){
						log.debug(key+" : "+hashMap.get(key));
					}
				}
				else{
					log.debug(basicObject);
				}
			}
		}
		else {
			log.debug(jsonObject);
		}

	}
}

/**
Json :
{
    "store": {
        "book": [
            {
                "category": "reference",
                "author": "Nigel Rees",
                "title": "Sayings of the Century",
                "price": 8.95
            },
            {
                "category": "fiction",
                "author": "Evelyn Waugh",
                "title": "Sword of Honour",
                "price": 12.99
            },
            {
                "category": "fiction",
                "author": "Herman Melville",
                "title": "Moby Dick",
                "isbn": "0-553-21311-3",
                "price": 8.99
            },
            {
                "category": "fiction",
                "author": "J. R. R. Tolkien",
                "title": "The Lord of the Rings",
                "isbn": "0-395-19395-8",
                "price": 22.99
            }
        ],
        "bicycle": {
            "color": "red",
            "price": 19.95
        }
    },
    "expensive": 10
}
Pattern :
$.store.book[*].author -> The authors of all books
$..author -> All authors
$.store.* -> All things, both books and bicycles
$.store..price -> The price of everything 
$..book[?(@.category == 'fiction')] -> All books with category fiction
$..book[2] -> The third book 
$..book[(@.length-1)] -> The last book
$..book[0,1] -> The first two books
$..book[:2] -> All books from index 0 (inclusive) until index 2 (exclusive)
$..book[1:2] -> All books from index 1 (inclusive) until index 2 (exclusive)
$..book[-2:] -> Last two books
$..book[2:] -> Book number two from tail
$..book[?(@.isbn)] -> All books with an ISBN number
$.store.book[?(@.price < 10)] -> All books in store cheaper than 10
$..book[?(@.price <= $['expensive'])] ->  All books in store that are not "expensive"
$..* -> Give me every thing
**/
 