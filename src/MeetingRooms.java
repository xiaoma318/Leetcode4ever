import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MeetingRooms {

  public static void main(String[] args) {
    int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
    System.out.println(minMeetingRooms(meetings));
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
    Map<Character, Integer> map = new HashMap<>();
    map.put('a', 3);
    map.put('b', 2);
    pq.addAll(map.entrySet());
    System.out.println(pq);
    System.out.println(pq.peek());
    Map.Entry<Character, Integer> entry = pq.poll();
   entry.setValue(1);
    pq.add(entry);
    System.out.println(map);
    System.out.println(pq);
    System.out.println(pq.peek());
    Queue<Integer> queue = new ArrayDeque<>();


  }

  /**
   * Meeting Rooms I Given an array of meeting time intervals consisting of start and end times [s1,
   * e1], [s2, e2], ... , determine if a person could attend all meetings.
   */
  static boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, (a, b) -> a.start - b.start);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < intervals[i - 1].end) {
        return false;
      }
    }
    return true;
  }

  /**
   * Leetcode 253
   * Meeting Rooms II Given an array of meeting time intervals consisting of start and end times
   * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
   *
   * Example 1: Input: [[0, 30],[5, 10],[15, 20]] Output: 2
   *
   * Example 2: Input: [[7,10],[2,4]] Output: 1
   */
  static int minMeetingRooms(int[][] meetings) {
    Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.offer(meetings[0][1]);
    for (int i = 1; i < meetings.length; i++) {
      if (priorityQueue.peek() <= meetings[i][0]) {
        priorityQueue.poll();
      }
      priorityQueue.offer(meetings[i][1]);

    }
    return priorityQueue.size();
  }

  static class Interval {

    int start, end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
