public class Codec {
    HashMap<String, Integer> longIdMap = new HashMap<String,Integer>();
    HashMap<Integer, String> longIdReverseMap = new HashMap<Integer, String>();
    HashMap<Integer, String> shortIdMap = new HashMap<Integer, String>();
    HashMap<String, Integer> shortIdReverseMap = new HashMap<String, Integer>();
    int count = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longIdMap.containsKey(longUrl)) {return shortIdMap.get(longIdMap.get(longUrl));}
        count++;
        longIdMap.put(longUrl, count);
        longIdReverseMap.put(count, longUrl);
        StringBuffer shortUrl = new StringBuffer("http://tinyurl.com/"+count);
        shortIdMap.put(count, shortUrl.toString());
        shortIdReverseMap.put(shortUrl.toString(), count);
        return shortUrl.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return longIdReverseMap.get(shortIdReverseMap.get(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));