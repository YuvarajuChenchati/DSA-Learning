package patterns.mergeintervals;

import java.util.*;

/**
 * Merge Intervals Implementation
 * 
 * This class contains essential merge intervals algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class MergeIntervals {
    
    /**
     * Merge overlapping intervals
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * @param intervals Array of intervals
     * @return Merged intervals
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // Non-overlapping, add current and start new
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        
        return result.toArray(new int[result.size()][]);
    }
    
    /**
     * Insert new interval
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param intervals Array of intervals
     * @param newInterval New interval to insert
     * @return Intervals with new interval inserted
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        
        // Add all intervals before new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        // Add remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    /**
     * Find interval intersections
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     * 
     * @param A First array of intervals
     * @param B Second array of intervals
     * @return Array of intersections
     */
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < A.length && j < B.length) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    /**
     * Check if person can attend all meetings
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * @param intervals Array of meeting intervals
     * @return True if can attend all meetings, false otherwise
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) return true;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Find minimum number of meeting rooms needed
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * 
     * @param intervals Array of meeting intervals
     * @return Minimum number of rooms needed
     */
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        // Sort start times
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0;
        int endIndex = 0;
        
        for (int start : starts) {
            if (start < ends[endIndex]) {
                rooms++;
            } else {
                endIndex++;
            }
        }
        
        return rooms;
    }
    
    /**
     * Find minimum number of arrows to burst balloons
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * @param points Array of balloon intervals
     * @return Minimum number of arrows needed
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
    
    /**
     * Remove covered intervals
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * @param intervals Array of intervals
     * @return Number of intervals after removing covered ones
     */
    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // Sort by end in descending order
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int count = 0;
        int end = Integer.MIN_VALUE;
        
        for (int[] interval : intervals) {
            if (interval[1] > end) {
                count++;
                end = interval[1];
            }
        }
        
        return count;
    }
    
    /**
     * Partition labels
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s Input string
     * @return List of partition sizes
     */
    public static List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
    
    /**
     * Employee free time
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * @param schedule List of employee schedules
     * @return List of free time intervals
     */
    public static List<int[]> employeeFreeTime(List<List<int[]>> schedule) {
        List<int[]> allIntervals = new ArrayList<>();
        
        // Flatten all intervals
        for (List<int[]> employee : schedule) {
            allIntervals.addAll(employee);
        }
        
        // Sort by start time
        allIntervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        
        for (int i = 1; i < allIntervals.size(); i++) {
            int[] prev = allIntervals.get(i - 1);
            int[] curr = allIntervals.get(i);
            
            if (prev[1] < curr[0]) {
                result.add(new int[]{prev[1], curr[0]});
            }
        }
        
        return result;
    }
    
    /**
     * My Calendar I
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static class MyCalendar {
        private List<int[]> bookings;
        
        public MyCalendar() {
            this.bookings = new ArrayList<>();
        }
        
        public boolean book(int start, int end) {
            for (int[] booking : bookings) {
                if (start < booking[1] && end > booking[0]) {
                    return false;
                }
            }
            bookings.add(new int[]{start, end});
            return true;
        }
    }
    
    /**
     * My Calendar II
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(n)
     */
    public static class MyCalendarTwo {
        private List<int[]> bookings;
        private List<int[]> overlaps;
        
        public MyCalendarTwo() {
            this.bookings = new ArrayList<>();
            this.overlaps = new ArrayList<>();
        }
        
        public boolean book(int start, int end) {
            for (int[] overlap : overlaps) {
                if (start < overlap[1] && end > overlap[0]) {
                    return false;
                }
            }
            
            for (int[] booking : bookings) {
                if (start < booking[1] && end > booking[0]) {
                    overlaps.add(new int[]{Math.max(start, booking[0]), Math.min(end, booking[1])});
                }
            }
            
            bookings.add(new int[]{start, end});
            return true;
        }
    }
    
    /**
     * Main method for testing merge intervals
     */
    public static void main(String[] args) {
        System.out.println("=== Merge Intervals Examples ===");
        
        // Test merge intervals
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(intervals);
        System.out.println("Merged intervals: " + Arrays.deepToString(merged));
        
        // Test insert interval
        int[][] newIntervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] inserted = insert(newIntervals, newInterval);
        System.out.println("Inserted interval: " + Arrays.deepToString(inserted));
        
        // Test interval intersection
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] intersections = intervalIntersection(A, B);
        System.out.println("Interval intersections: " + Arrays.deepToString(intersections));
        
        // Test meeting rooms
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Can attend all meetings: " + canAttendMeetings(meetings));
        System.out.println("Minimum meeting rooms: " + minMeetingRooms(meetings));
        
        // Test balloons
        int[][] balloons = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Minimum arrows: " + findMinArrowShots(balloons));
        
        // Test covered intervals
        int[][] covered = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println("Remove covered intervals: " + removeCoveredIntervals(covered));
        
        // Test partition labels
        String s = "ababcbacadefegdehijhklij";
        System.out.println("Partition labels: " + partitionLabels(s));
        
        // Test My Calendar
        MyCalendar calendar = new MyCalendar();
        System.out.println("Book (10, 20): " + calendar.book(10, 20));
        System.out.println("Book (15, 25): " + calendar.book(15, 25));
        System.out.println("Book (20, 30): " + calendar.book(20, 30));
    }
}
