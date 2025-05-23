class Solution {
    public int compress(char[] chars) {
        int startStreak = 0;
        int indexAnswer = 0;

        while(startStreak < chars.length) {
            char currChar = chars[startStreak];


            int endStreak = startStreak;
            int count = 1;
            while (endStreak + 1 < chars.length && chars[endStreak + 1] == currChar) {
                count++;
                endStreak++;
            }

            chars[indexAnswer] = currChar;
            indexAnswer++;

            if(count > 1) {
                char[] toChar = Integer.toString(count).toCharArray();
                for(char a: toChar) {
                    chars[indexAnswer] = a;
                    indexAnswer++;
                }
            }

            startStreak = endStreak + 1;
        }

        return indexAnswer;
    }
}
