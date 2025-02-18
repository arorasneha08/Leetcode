class Solution {
    private String result = null;

    public boolean generateSequence(int index, boolean[] visited, StringBuilder sb, String pattern) {
        if (sb.length() == pattern.length() + 1) {
            result = sb.toString();
            return true;
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (!visited[digit]) {
                if (sb.length() > 0) {
                    int prevDigit = sb.charAt(sb.length() - 1) - '0';
                    char condition = pattern.charAt(sb.length() - 1); 
                    if (condition == 'I' && prevDigit >= digit) continue;
                    if (condition == 'D' && prevDigit <= digit) continue;
                }
                visited[digit] = true;
                sb.append(digit);

                if (generateSequence(index + 1, visited, sb, pattern)) {
                    return true;
                }

                sb.deleteCharAt(sb.length() - 1);
                visited[digit] = false;
            }
        }
        return false;
    }

    public String smallestNumber(String pattern) {
        boolean[] visited = new boolean[10];
        StringBuilder sb = new StringBuilder();
        generateSequence(0, visited, sb, pattern);
        return result;
    }
}
