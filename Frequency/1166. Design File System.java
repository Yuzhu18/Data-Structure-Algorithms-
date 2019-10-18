// HashMap <Path, value>
// 每次create的时候先验证 前面的path是否存在
// createPath ： time： O(n) - substring() complexity
// get: O(1) - check map

class FileSystem {
    Map<String, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
        map.put("", 0);
    }
    
    public boolean createPath(String path, int value) {
        if (map.containsKey(path)) {
            return false;
        }
        int lastSlashIndex = path.lastIndexOf("/");
        if (!map.containsKey(path.substring(0, lastSlashIndex))) {
            return false;
        }
        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        if (!map.containsKey(path)) {
            return -1;
        }
        return map.get(path);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
