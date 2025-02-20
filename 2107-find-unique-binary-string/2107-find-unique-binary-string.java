class Solution {
    private void backtrack(int index, StringBuilder str, ArrayList<String> res, char ch[], int n) {
        if (index == n) {
            res.add(str.toString());
            return;
        }
        for (char c : ch) {
            str.append(c);
            backtrack(index + 1, str, res, ch, n);
            str.deleteCharAt(str.length() - 1); 
        }
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        ArrayList<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for (String num : nums) {
            set.add(num);
        }

        char ch[] = {'0', '1'};
        backtrack(0, new StringBuilder(), res, ch, n);

        for (String s : res) {
            if (!set.contains(s)) {
                return s;
            }
        }
        return ""; 
    }
}
