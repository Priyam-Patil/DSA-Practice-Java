import java.util.*;


// Question:
// Given jobs with job id, deadline, and profit.
// Each job takes 1 unit of time.
// Only one job can be scheduled at a time.
// Find the job sequence that gives maximum profit.

// Sort jobs in descending order of profit.
// Highest profit job should be considered first.

// Find the maximum deadline to create required time slots.

// result[] stores selected job ids.
// slot[] checks whether a particular time slot is already occupied.
// By default, boolean array values are false.

// Try to place each job in the latest available slot before its deadline.

// job.deadline is used because each job must finish before its own deadline.

// If the slot is empty, assign the job to that slot.

// Add selected job's profit to maximum profit.

// Once job is placed, stop checking further slots for that job.
// break stops only the inner loop.

// Print all selected jobs from slot 1 to maxDeadline.
// Index 0 is unused because deadlines start from 1.


public class Job_Sequencing_Problem {
    public static class JOB {
        char id;
        int deadline;
        int profit;

        JOB(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void jobsequencing(JOB jobs[]) {
        // sort data in descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);// sort in descending
        // a.profit-b.profit sort in ascending

        // find maxDeadline
        int maxdeadline = 0;
        for (JOB job : jobs) {
            maxdeadline = Math.max(maxdeadline, job.deadline);
        }

        char result[] = new char[maxdeadline + 1];// for storing selected id's
        boolean slot[] = new boolean[maxdeadline + 1];
        // for allocating slot's

        int maxProfit = 0;
        for (JOB job : jobs) {
            // Because each job must be placed before its own deadline
            for (int i = job.deadline; i >= 1; i--) {
                if (!slot[i]) {// bydefault boolean arr stores all places as false
                    slot[i] = true;
                    result[i] = job.id;
                    maxProfit += job.profit;
                    break;// break when one slot is allocated and now check for next
                          // job(id,deadline,profit).

                }
            }
        }
        System.out.println("selected jobs");
        for (int i = 1; i <= maxdeadline; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");

            }
        }
        System.out.println();
        System.out.println("max profit is for selected jobs:" + maxProfit);

    }

    public static void main(String[] args) {
        JOB jobs[] = {
                new JOB('a', 4, 20),
                new JOB('b', 1, 10),
                new JOB('c', 4, 40),
                new JOB('d', 1, 30),

        };
        jobsequencing(jobs);
    }
}