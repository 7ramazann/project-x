class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hashMap = new HashMap<>();
        for(String word: words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> maxH = new PriorityQueue<>((a,b) -> {
            int freqCompare = hashMap.get(b) - hashMap.get(a);
            if(freqCompare != 0) return freqCompare;
            return a.compareTo(b);
        });

        for(String word: hashMap.keySet()) {
            maxH.offer(word);
            // if(minHeap.size() > k) {
            //     minHeap.poll();
            // }
        }

        List<String> res = new ArrayList<>();
        // while(!minHeap.isEmpty()) {
        //     res.add(minHeap.poll());
        // }
        for(int i = 0; i < k; i++) {
            res.add(maxH.poll());
        }

        // Collections.reverse(res);
        return res;
    }
}
