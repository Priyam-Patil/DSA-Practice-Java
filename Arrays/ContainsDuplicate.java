import java.util.*;

// Question:
// Given an integer array nums, return true if any value appears at least twice.
// Return false if every element is distinct.

// LeetCode 217 - Contains Duplicate

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true; // duplicate found
            }
            set.add(num);
        }

        return false; // all elements are distinct
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums)); // true
    }
}