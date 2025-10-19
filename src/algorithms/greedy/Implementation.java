package algorithms.greedy;

import java.util.*;

/**
 * Greedy Algorithms Implementation
 * 
 * This class contains essential greedy algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class GreedyAlgorithms {
    
    /**
     * Activity selection problem
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * @param activities Array of activities [start, end]
     * @return Maximum number of activities that can be performed
     */
    public static int maxActivities(int[][] activities) {
        if (activities.length == 0) return 0;
        
        // Sort by finish time
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 1;
        int lastFinish = activities[0][1];
        
        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] >= lastFinish) {
                count++;
                lastFinish = activities[i][1];
            }
        }
        
        return count;
    }
    
    /**
     * Assign cookies to children
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * @param g Greed factor of children
     * @param s Size of cookies
     * @return Maximum number of content children
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0, j = 0;
        int count = 0;
        
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        
        return count;
    }
    
    /**
     * Lemonade change
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param bills Array of bill denominations
     * @return True if can provide change, false otherwise
     */
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Gas station problem
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param gas Gas available at each station
     * @param cost Cost to travel from each station
     * @return Starting station index, or -1 if impossible
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0, currentTank = 0, startStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }
        
        return totalTank >= 0 ? startStation : -1;
    }
    
    /**
     * Jump game
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of jump lengths
     * @return True if can reach last index, false otherwise
     */
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        
        return true;
    }
    
    /**
     * Jump game II - minimum jumps
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param nums Array of jump lengths
     * @return Minimum number of jumps to reach last index
     */
    public static int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }
    
    /**
     * Minimum number of arrows to burst balloons
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
     * Remove K digits to make smallest number
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param num Input number as string
     * @param k Number of digits to remove
     * @return Smallest number after removing k digits
     */
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // Remove remaining digits
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Build result
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();
        
        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
    
    /**
     * Candy distribution
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param ratings Array of ratings
     * @return Minimum number of candies needed
     */
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }
    
    /**
     * Queue reconstruction by height
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * @param people Array of people [height, k]
     * @return Reconstructed queue
     */
    public static int[][] reconstructQueue(int[][] people) {
        // Sort by height in descending order, then by k in ascending order
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        List<int[]> result = new ArrayList<>();
        
        for (int[] person : people) {
            result.add(person[1], person);
        }
        
        return result.toArray(new int[result.size()][]);
    }
    
    /**
     * Huffman coding node
     */
    public static class HuffmanNode {
        char data;
        int frequency;
        HuffmanNode left, right;
        
        public HuffmanNode(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
        }
    }
    
    /**
     * Build Huffman tree
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * 
     * @param data Array of characters
     * @param freq Array of frequencies
     * @return Root of Huffman tree
     */
    public static HuffmanNode buildHuffmanTree(char[] data, int[] freq) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
        
        for (int i = 0; i < data.length; i++) {
            pq.offer(new HuffmanNode(data[i], freq[i]));
        }
        
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            
            HuffmanNode merged = new HuffmanNode('$', left.frequency + right.frequency);
            merged.left = left;
            merged.right = right;
            
            pq.offer(merged);
        }
        
        return pq.poll();
    }
    
    /**
     * Print Huffman codes
     * 
     * @param root Root of Huffman tree
     * @param code Current code
     */
    public static void printCodes(HuffmanNode root, String code) {
        if (root == null) return;
        
        if (root.data != '$') {
            System.out.println(root.data + ": " + code);
        }
        
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }
    
    /**
     * Fractional knapsack
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     * 
     * @param weights Array of weights
     * @param values Array of values
     * @param capacity Knapsack capacity
     * @return Maximum value that can be obtained
     */
    public static double fractionalKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        double[][] items = new double[n][3];
        
        for (int i = 0; i < n; i++) {
            items[i][0] = weights[i];
            items[i][1] = values[i];
            items[i][2] = values[i] / (double) weights[i]; // value per unit weight
        }
        
        // Sort by value per unit weight in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b[2], a[2]));
        
        double totalValue = 0;
        int remainingCapacity = capacity;
        
        for (int i = 0; i < n && remainingCapacity > 0; i++) {
            if (items[i][0] <= remainingCapacity) {
                totalValue += items[i][1];
                remainingCapacity -= items[i][0];
            } else {
                totalValue += items[i][1] * (remainingCapacity / items[i][0]);
                remainingCapacity = 0;
            }
        }
        
        return totalValue;
    }
    
    /**
     * Main method for testing greedy algorithms
     */
    public static void main(String[] args) {
        System.out.println("=== Greedy Algorithms Examples ===");
        
        // Test activity selection
        int[][] activities = {{1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 8}, {5, 9}, {6, 10}, {8, 11}, {8, 12}, {2, 13}, {12, 14}};
        System.out.println("Maximum activities: " + maxActivities(activities));
        
        // Test assign cookies
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println("Content children: " + findContentChildren(g, s));
        
        // Test lemonade change
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println("Lemonade change: " + lemonadeChange(bills));
        
        // Test gas station
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println("Gas station: " + canCompleteCircuit(gas, cost));
        
        // Test jump game
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Can jump: " + canJump(nums));
        System.out.println("Minimum jumps: " + jump(nums));
        
        // Test balloons
        int[][] balloons = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Minimum arrows: " + findMinArrowShots(balloons));
        
        // Test remove digits
        System.out.println("Remove digits: " + removeKdigits("1432219", 3));
        
        // Test candy
        int[] ratings = {1, 0, 2};
        System.out.println("Minimum candies: " + candy(ratings));
        
        // Test queue reconstruction
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println("Reconstructed queue: " + Arrays.deepToString(reconstructQueue(people)));
        
        // Test Huffman coding
        char[] data = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};
        HuffmanNode root = buildHuffmanTree(data, freq);
        System.out.println("Huffman codes:");
        printCodes(root, "");
        
        // Test fractional knapsack
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        System.out.println("Fractional knapsack: " + fractionalKnapsack(weights, values, capacity));
    }
}
