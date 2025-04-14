class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> res = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!res.containsKey(sortedWord)) {
                res.put(sortedWord, new ArrayList<>());
            }
            res.get(sortedWord).add(word);
        }

        return new ArrayList<>(res.values());
    }
}
