package foldername;

import java.util.*;

public class Solution {

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>(names.length);
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int startIndex = name.lastIndexOf("(");
            int endIndex = name.lastIndexOf(")");
            if (startIndex != -1 && endIndex != -1) {
                try {
                    int num = Integer.parseInt(name.substring(startIndex + 1, endIndex));
                    String nameStr = name.substring(0, startIndex);
                    if (map.containsKey(nameStr) && num == map.get(nameStr) + 1) {
                        map.put(nameStr, num);
                    }
                } catch (NumberFormatException e) {

                }
            }
            if (map.containsKey(name)) {
                int num = map.get(name);
                num++;
                String nameStr = name;
                name = name + "(" + num + ")";
                while (map.containsKey(name)) {
                    num++;
                    name = nameStr + "(" + num + ")";
                }
                map.put(name, map.getOrDefault(name, 0));
            } else {
                map.put(name, 0);
            }
            res[i] = name;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] data = {"pes", "fifa", "gta", "pes(2019)"};
        System.out.println(Arrays.toString(new Solution().getFolderNames(data)));
        String[] data1 = {"gta", "gta(1)", "gta", "avalon"};
        System.out.println(Arrays.toString(new Solution().getFolderNames(data1)));
        String[] data2 = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        System.out.println(Arrays.toString(new Solution().getFolderNames(data2)));
        String[] data3 = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        System.out.println(Arrays.toString(new Solution().getFolderNames(data3)));
        String[] data4 = {"kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)"};
        System.out.println(Arrays.toString(new Solution().getFolderNames(data4)));
    }
}
