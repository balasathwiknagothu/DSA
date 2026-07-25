class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>(), 0);
        return result;
    }

    void backtrack(String s, List<String> result, List<String> temp, int index) {

        if (temp.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", temp));
            }
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0')
                continue;

            if (Integer.parseInt(part) > 255)
                continue;

            temp.add(part);

            backtrack(s, result, temp, index + len);

            temp.remove(temp.size() - 1);
        }
    }
}