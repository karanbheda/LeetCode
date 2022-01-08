class FileSystem {

    class FSObject {
        String name;
        boolean isFolder;
        Map<String, FSObject> folderContent;
        
        FSObject(String name, boolean isFolder) {
            this.name = name;
            this.isFolder = isFolder;
            if(isFolder) {
                folderContent = new TreeMap<>();
            }
        }
        
        public String toString() {
            return "[name="+name+" ,isFolder="+isFolder+", content="+folderContent+"]";
        }
    }
    
    class File extends FSObject {
        StringBuilder sb = new StringBuilder();
        
        File(String name, boolean isFolder) {
            super(name, isFolder);
        }
    }
    
    FSObject root;
    
    public FileSystem() {
        this.root = new FSObject("", true);
    }
    
    public List<String> ls(String path) {
        String[] parts = path.split("/");
        FSObject pointer = root;
        for(int i = 0; i < parts.length; i++) {
            if(parts[i].isEmpty()) {continue;}
            pointer = pointer.folderContent.get(parts[i]);
        }
        
        //System.out.println(root);
        
        if(pointer.isFolder) {
            return new ArrayList<>(pointer.folderContent.keySet());
        }
        
        List<String> list = new ArrayList<>();
        list.add(pointer.name);
        
        return list;
    }
    
    public void mkdir(String path) {
        String[] parts = path.split("/");
        FSObject pointer = root;
        for(int i = 0; i < parts.length; i++) {
            if(parts[i].isEmpty())continue;
            FSObject nextFolder = pointer.folderContent.getOrDefault(parts[i], new FSObject(parts[i], true));
            pointer.folderContent.put(parts[i], nextFolder);
            pointer = nextFolder;
        }
    }
    
    private FSObject navigateToDir(String folderPath) {
        
        mkdir(folderPath);
        
        String[] parts = folderPath.split("/");
        FSObject pointer = root;
        for(int i = 0; i < parts.length; i++) {
            if(parts[i].isEmpty())continue;
            pointer = pointer.folderContent.get(parts[i]);
        }
        return pointer;
    }
    
    public void addContentToFile(String filePath, String content) {
        int idx = filePath.lastIndexOf("/");
        String folderPath = "";
        String fileName = filePath;
        if(idx != -1)  {
            folderPath = filePath.substring(0, idx);
            fileName = filePath.substring(idx+1);
        }
        FSObject folder = navigateToDir(folderPath);
        File file = (File) folder.folderContent.getOrDefault(fileName, new File(fileName, false) ) ;
        file.sb.append(content);
        folder.folderContent.put(fileName, file);
    }
    
    public String readContentFromFile(String filePath) {
        int idx = filePath.lastIndexOf("/");
        String folderPath = "";
        String fileName = filePath;
        if(idx != -1)  {
            folderPath = filePath.substring(0, idx);
            fileName = filePath.substring(idx+1);
        }
        FSObject folder = navigateToDir(folderPath);
        File file = (File)folder.folderContent.get(fileName);
        return file.sb.toString();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */