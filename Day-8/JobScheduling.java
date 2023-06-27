import java.util.ArrayList;
import java.util.List;

class Pair {
    int deadline;
    int profit;
    int id;

    Pair(int id, int dline, int pro) {
        this.id = id;
        this.deadline = dline;
        this.profit = pro;
    }
}

public class JobScheduling {

    public static int jobScheduling(int[][] jobs) {
        List<Pair> al = new ArrayList<>();
        int totalProfit = 0;
        int n = jobs.length;
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            al.add(new Pair(i + 1, jobs[i][0], jobs[i][1]));
            maxi = Math.max(maxi, jobs[i][0]);
        }
        al.sort((a, b) -> b.profit - a.profit);
        int[] jobId = new int[maxi + 1];
        for (Pair pair : al) {
            int idx = pair.deadline;
            while (idx > 0 && jobId[idx] != 0) {
                idx--;
            }
            if (idx > 0) {
                jobId[idx] = pair.id;
                totalProfit += pair.profit;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[][] jobs = { { 2, 30 }, { 2, 40 }, { 1, 10 }, { 1, 10 } };
        System.out.println(jobScheduling(jobs));
    }
}
