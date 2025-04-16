class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x: nums) {
            map.put(x, map.getOrDefault(x,0)+1);
        }

        List<Pair<Integer, Integer>> sorted_freq = new ArrayList<>();
        for(var entry : map.entrySet()){
            Pair<Integer, Integer> freq_pair = new Pair<>(entry.getKey(), entry.getValue());
            sorted_freq.add(freq_pair);
        }

        // Sort  
        Collections.sort(sorted_freq, (fp1, fp2) -> {
            return fp2.getValue() - fp1.getValue();
        });

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = sorted_freq.get(i).getKey();
        }

        return res;
    }
}
