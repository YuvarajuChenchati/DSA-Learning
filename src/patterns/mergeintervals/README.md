# Merge Intervals Pattern 🔗

> **Master the merge intervals technique for overlapping interval problems**

## 🎯 Learning Objectives

- Understand merge intervals fundamentals
- Master interval sorting and merging
- Learn when to use merge intervals
- Apply merge intervals to solve problems

## 📚 Theory

### Merge Intervals Basics

#### Properties
- **Sorting**: Sort intervals by start time
- **Merging**: Combine overlapping intervals
- **Overlap detection**: Check if intervals overlap
- **Efficient**: O(n log n) time complexity
- **Common pattern**: Many interval problems use this approach

#### Common Operations
- **Merge overlapping intervals**: Combine intervals that overlap
- **Insert new interval**: Add interval to sorted list
- **Find intersections**: Find common intervals
- **Remove covered intervals**: Remove intervals covered by others
- **Interval scheduling**: Schedule maximum non-overlapping intervals

### When to Use Merge Intervals

#### Interval Problems
- **Meeting rooms**: Schedule meetings without conflicts
- **Calendar**: Merge overlapping calendar events
- **Time intervals**: Handle time-based problems
- **Range queries**: Process range-based data
- **Scheduling**: Optimize resource allocation

#### Overlap Detection
- **Conflicting appointments**: Find scheduling conflicts
- **Resource allocation**: Check resource availability
- **Time conflicts**: Detect time overlaps
- **Range intersections**: Find overlapping ranges

## 🔧 Implementation

### Basic Merge Intervals Pattern

```java
// Merge overlapping intervals
public int[][] merge(int[][] intervals) {
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
```

### Advanced Merge Intervals Patterns

```java
// Insert new interval
public int[][] insert(int[][] intervals, int[] newInterval) {
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
```

## 📝 Practice Problems

### Easy
1. **Merge Intervals** - O(n log n) time, O(1) space
2. **Insert Interval** - O(n) time, O(1) space
3. **Interval List Intersections** - O(n + m) time, O(1) space
4. **Meeting Rooms** - O(n log n) time, O(1) space
5. **Non-overlapping Intervals** - O(n log n) time, O(1) space

### Medium
1. **Meeting Rooms II** - O(n log n) time, O(n) space
2. **Employee Free Time** - O(n log n) time, O(1) space
3. **Minimum Number of Arrows** - O(n log n) time, O(1) space
4. **Remove Covered Intervals** - O(n log n) time, O(1) space
5. **Partition Labels** - O(n) time, O(1) space

### Hard
1. **My Calendar I** - O(n) time, O(n) space
2. **My Calendar II** - O(n²) time, O(n) space
3. **My Calendar III** - O(n²) time, O(n) space
4. **Range Module** - O(n) time, O(n) space
5. **Data Stream as Disjoint Intervals** - O(n) time, O(n) space

## 💡 Key Insights

- **Sort first**: Always sort intervals by start time
- **Check overlap**: Use start and end times to detect overlap
- **Merge condition**: Intervals overlap if start <= previous end
- **Update end**: Take maximum of current and previous end
- **Handle edge cases**: Empty intervals, single intervals

## 🎯 Interview Tips

- Always sort intervals by start time
- Consider both start and end times
- Handle edge cases (empty, single intervals)
- Think about time complexity optimization
- Use appropriate data structures

## 📚 Additional Resources

- [Merge Intervals](https://www.geeksforgeeks.org/merging-intervals/)
- [Interval Scheduling](https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/)
- [Calendar Problems](https://www.geeksforgeeks.org/calendar-problems/)
- [Range Queries](https://www.geeksforgeeks.org/range-queries/)
