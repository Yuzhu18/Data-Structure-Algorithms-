public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
  
    // two poniters
    List<Integer> rst = new ArrayList<>();
    int pointA = 0;
    int pointB = 0;
    while(pointA < A.size() && pointB < B.size()){
      if(A.get(pointA) == B.get(pointB)){
        rst.add(A.get(pointA));
        pointA++;
        pointB++;
      }else if(A.get(pointA) > B.get(pointB)){
        pointB++;
      }else{
        pointA++;
      }
    }
    return rst;
  }
}
