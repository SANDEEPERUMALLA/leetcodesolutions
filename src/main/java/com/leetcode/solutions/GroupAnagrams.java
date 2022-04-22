package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    https://leetcode.com/problems/group-anagrams/
    49. Group Anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            char[] ch = new char[26];
            for (int i = 0; i < s.length(); i++) {
                ch[s.charAt(i) - 'a']++;
            }
            String key = new String(ch);
            result.computeIfAbsent(key, (k) -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(result.values());
    }
}
