class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0;
        int i = 0;

        while (i < n) {
            char currChar = chars[i];
            int count = 0;

            while (i < n && chars[i] == currChar) {
                i++;
                count++;
            }

            chars[index++] = currChar;

            if (count > 1) {
                String numStr = Integer.toString(count);
                for (int j = 0; j < numStr.length(); j++) {
                    chars[index++] = numStr.charAt(j);
                }
            }
        }

        return index;
    }
}
