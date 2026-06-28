/*
Question: Activity Selection Problem

Given start[] and end[] arrays of activities.
Find the maximum number of activities that can be performed by one person.

Greedy Approach:
Sort activities based on ending time.
Then select the activity whose start time is >= last selected activity end time.

Similar LeetCode:
LeetCode 435 - Non-overlapping Intervals
*/

import java.util.*;

public class ActivitySelection1 {
    public static void main(String[] args) {
        int start[] = {3, 5, 5, 1, 8, 0};
        int end[] = {4, 7, 9, 2, 9, 6}; // not sorted

        int activity[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activity[i][0] = i;        // original activity index
            activity[i][1] = start[i]; // start time
            activity[i][2] = end[i];   // end time
        }

        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2])); // sort second col/end time

        int maxAct = 1;
        ArrayList<Integer> a = new ArrayList<>();

        // for first activity
        a.add(activity[0][0]); // add original index of first selected activity
        int lastEnd = activity[0][2];

        for (int i = 1; i < activity.length; i++) {
            if (activity[i][1] >= lastEnd) {
                maxAct++;
                a.add(activity[i][0]);
                lastEnd = activity[i][2];
            }
        }

        System.out.println("Maximum activity: " + maxAct);

        for (int i = 0; i < a.size(); i++) {
            System.out.print("A" + a.get(i) + " ");
        }
    }
}