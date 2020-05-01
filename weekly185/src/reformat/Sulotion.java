package reformat;

public class Sulotion {
    public String reformat(String s) {
        StringBuilder res = new StringBuilder();
        int pa = 0;
        int pn = 0;
        int len = s.length();
        boolean findAbc = true;
        while (pa < len && pn < len) {
            if (findAbc) {
                char ch = s.charAt(pa);
                if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
                    res.append(ch);
                    findAbc = false;
                }
                pa++;
            } else {
                char ch = s.charAt(pn);
                if ('0' <= ch && ch <= '9') {
                    res.append(ch);
                    findAbc = true;
                }
                pn++;
            }
        }
//        if(pa<len)
//        {
//            if(!findAbc)
//        }
        return res.length() == len ? res.toString() : "";
    }

    public static void main(String[] args) {
        //        System.out.println(new Sulotion().reformat("abc123"));
        //        System.out.println(new Sulotion().reformat("a0b1c2"));
        //        System.out.println(new Sulotion().reformat("leetcode"));
        System.out.println(new Sulotion().reformat("covid2019"));
        System.out.println(new Sulotion().reformat("covid201904"));
    }
}
