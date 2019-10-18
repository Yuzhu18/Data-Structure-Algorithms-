import java.util.*;

public class Main {

    // File System ,with call back
    // Watch add the callback function
    // Space: O(n)
    public static void main(String[] args) {
        FileSystem file = new FileSystem();
        boolean a = file.create("/a",1);
        System.out.println("create /a: " + a);

        boolean watch = file.watch("/a", new Runnable(){
            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                System.out.println("aaa");
            }
        });
        System.out.println("watch /a : " + watch);

        boolean b = file.create("/a/b",2);
        System.out.println("create /a/b: " + b);

        int c = file.get("/a/c");
        System.out.println("get /a/c: " + c);

        int d = file.get("/a/b");
        System.out.println("get /a/b: " + d);

        boolean e = file.set("/a/b", 10);
        System.out.println("set /a/b 10 : " + e);


        int f = file.get("/a/b");
        System.out.println("get /a/b: " + f);

    }


    private static class FileSystem {

        private Map<String, Integer> pathMap;
        private Map<String, Runnable> callbackMap;

        private FileSystem() {
            this.pathMap = new HashMap<String, Integer>();
            this.callbackMap = new HashMap<String, Runnable>();
            this.pathMap.put("", 0);
        }

        // time: O(n) - substring() / callback
        private boolean create(String path, int value) {
            // if it already exist this path ? return False ?
            if (pathMap.containsKey(path)) {
                return false;
            }

            int lastSlashIndex = path.lastIndexOf("/");
            if (!pathMap.containsKey(path.substring(0, lastSlashIndex))) {
                return false;
            }
            pathMap.put(path, value);

            ///// Trigger callbacks
            String curPath = path;
            while (curPath.length() > 0) {
                if (callbackMap.containsKey(curPath)) {
                    callbackMap.get(curPath).run();
                }
                int curLastSlash = curPath.lastIndexOf("/");
                curPath = curPath.substring(0, curLastSlash);
            }
            //////  Trigger callbacks

            return true;
        }

        // time: O(1)
        private boolean set(String path, int value) {
            if (!pathMap.containsKey(path)) {
                return false;
            }
            pathMap.put(path, value);
            return true;
        }

        // time: O(1)
        private Integer get(String path) {
            if (!pathMap.containsKey(path)) {
                return -1;
            }
            return pathMap.get(path);
        }

        // time: O(1)
        private boolean watch(String path, Runnable callback) {
            if (!pathMap.containsKey(path)) {
                return false;
            }
            callbackMap.put(path, callback);
            return true;
        }
    }
}
