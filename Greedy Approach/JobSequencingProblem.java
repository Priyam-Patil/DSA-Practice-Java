/*
Question: Job Sequencing Problem

Given jobs with:
1. Job id
2. Deadline
3. Profit

Each job takes 1 unit of time.
Only one job can be done at a time.
Find selected jobs to get maximum profit.

Greedy Approach:
Sort jobs in descending order of profit.
For each job, place it in the latest available slot before its deadline.

LeetCode:
Job Sequencing Problem is not directly on LeetCode.
It is a classic Greedy problem.
*/

import java.util.*;

public class JobSequencingProblem {

    public static class Job {

        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void sequencing(Job jobs[]) {
        // sort array in descending order of profit
        // Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));

        // b.profit - a.profit
        // = 40 - 20
        // = positive
        // Positive means b should come before a.

        int maxDeadline = 0;

        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        char result[] = new char[maxDeadline + 1]; // +1 because deadlines are start from 1 and not 0 and this array stores the id's
        boolean slot[] = new boolean[maxDeadline + 1];

        int maxProfit = 0;

        for (Job job : jobs) {
            for (int i = job.deadline; i >= 1; i--) {
                if (!slot[i]) { // bydefault boolean array assign all places false
                    slot[i] = true;
                    result[i] = job.id;
                    maxProfit += job.profit;
                    break; // break when one slot is allocated
                }
            }
        }

        System.out.println("Selected Jobs are:");

        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");
            }
        }

        System.out.println();
        System.out.println("Maximum profit of selected jobs is: " + maxProfit);
    }

    public static void main(String[] args) {
        Job jobs[] = {
            new Job('A', 4, 20),
            new Job('B', 1, 10),
            new Job('C', 1, 40),
            new Job('D', 1, 30)
        };

        sequencing(jobs);
    }
}