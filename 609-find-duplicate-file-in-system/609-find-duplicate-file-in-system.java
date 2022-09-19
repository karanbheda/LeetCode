class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> duplicateList = new ArrayList<>();
        Map<String, List<String>> duplicateMap = new HashMap<>();
        
        for(String path: paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];
            
            if(dir.charAt(dir.length() - 1) != '/') {
                dir += "/";
            }
            
            for(int i = 1; i < parts.length; i++) {
                int idx = parts[i].indexOf("(");
                String fileName = parts[i].substring(0, idx);
                String content = parts[i].substring(idx+1, parts[i].length());
                List<String> list = duplicateMap.getOrDefault(content, new ArrayList<>());
                list.add(dir + fileName);
                duplicateMap.put(content, list);
            }
        }
        
        
        duplicateMap.forEach((content, list) -> {
            if(list.size() > 1) {
                duplicateList.add(list);
            }
        });
        
        return duplicateList;
    }
}