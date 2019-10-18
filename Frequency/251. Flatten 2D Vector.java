// Time: O(n)
// Space: O(n)

class Vector2D {
    private int[][] v;
    private int i;
    private int j;
    public Vector2D(int[][] v) {
        this.v = v;
        this.i = 0;
        this.j = 0;
    }
    
    public int next() {
        hasNext();
        return v[i][j++];    
    }
    
    public boolean hasNext() {
        while(i < v.length) {
            if(j < v[i].length) {
                return true;
            }
            i++;
            j = 0;
        }
        return false;
    }
}
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
