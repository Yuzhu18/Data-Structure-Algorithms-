/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};
*/

// 先排序order by start time
// 然后记录一个当前的time，每次能merge就extend time， 
// 如果不能说明是free time 的时间段，放进结果
// 可以直接用arraylist sort， 也可以放进PiorityQueue 里面

// Time: O(nlogn) -because of sort, where n is the total number of intervals.
// Space: O(n)

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allInterval = new ArrayList<>();
        for (List<Interval> list : schedule) {
            allInterval.addAll(list);
        }
        Collections.sort(allInterval, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> rst = new ArrayList<>();
        int endTime = allInterval.get(0).end;
        for (int i = 1; i < allInterval.size(); i++) {
            // there should be a free time interval
            if (allInterval.get(i).start > endTime) {
                rst.add(new Interval(endTime, allInterval.get(i).start));
                endTime = allInterval.get(i).end;
            // this interval can merge 
            } else {
                endTime = Math.max(endTime, allInterval.get(i).end);
            }
        }
        return rst;
    }
}
