class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double[][] workers = new double[quality.length][2];
        for (int i = 0; i < wage.length; i++) {
            workers[i][0] = (double) wage[i]/quality[i];
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int qualitySum = 0;
        double minCost = Double.MAX_VALUE;

        for (double[] worker: workers) {
            int qual = (int) worker[1];
            double ratio = worker[0];

            maxHeap.offer(qual);
            qualitySum += qual;

            if(maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                double cost = ratio * qualitySum;
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;


    }
}
