// Generate binary numbers from 1 to N using a Queue.
import java.util.*;

public class Generate_BinaryNumbers_Q1 {
    public static void DecimalToBinary(int n) {

        Queue<String> q = new LinkedList<>();
        // We use String because binary numbers are being printed as text pattern, not
        // used for calculation.

        q.add("1");
        for (int i = 1; i <= n; i++) {
            String curr = q.remove();
            System.out.print(curr + " ");

            q.add(curr + "0");
            q.add(curr + "1");

        }
    }

    public static void main(String[] args) {
        int n = 10;
        DecimalToBinary(n);
    }
}
