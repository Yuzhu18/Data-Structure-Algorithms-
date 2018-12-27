//time: sort O(nlogn)
//space: list O(n)

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new myComparator());
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i = 0; i < intervals.size(); i++){
            if(intervals.get(i).start <= end){
                end = Math.max(intervals.get(i).end, end);
            }else{
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}

class myComparator implements Comparator<Interval>{
    @Override
    public int compare(Interval o1, Interval o2){
        return o1.start - o2.start;
    }
}
