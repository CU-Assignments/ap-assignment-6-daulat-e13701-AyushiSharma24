package Academics.AP2.Experiment6;

class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }
        for (String word : wordDict)
            if (s.startsWith(word))
                for (String sub : helper(s.substring(word.length()), wordDict, memo))
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
        memo.put(s, result);
        return result;
    }
}
