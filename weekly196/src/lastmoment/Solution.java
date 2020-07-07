package lastmoment;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        Entry[] postion = new Entry[n + 1];
        for (int i = 0; i < postion.length; i++) {
            postion[i] = new Entry();
        }
        for (int i = 0; i < left.length; i++) {
            Ant ant = new Ant();
            ant.left = true;
            ant.pos = left[i];
            postion[ant.pos].ants.add(ant);
        }
        for (int i = 0; i < right.length; i++) {
            Ant ant = new Ant();
            ant.left = false;
            ant.pos = right[i];
            postion[ant.pos].ants.add(ant);
        }
        System.out.println(Arrays.toString(postion));
        int count = left.length + right.length;
        int time = 0;
        while (count > 0) {
            for (int i = 0; i < postion.length; i++) {
                Entry entries = postion[i];
                if (entries.ants.size() == 2) {
                    // convert

                }
            }
            time++;
        }
        return time;
    }

    class Entry {
        List<Ant> ants = new ArrayList<>();

        @Override
        public String toString() {
            return "Entry{" +
                    "ants=" + ants +
                    '}';
        }
    }

    class Ant {
        int pos;
        boolean left;

        @Override
        public String toString() {
            return "{" +
                    "" + pos +
                    ", " + left +
                    '}';
        }
    }
    public int getLastMoment_best(int n, int[] left, int[] right){
        int[] position = new int[n+1];
        for(int i=0;i<left.length;i++){
            //position[]
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] left = {4, 3};
        int[] right = {0, 1};
        System.out.println(new Solution().getLastMoment(4, left, right));
    }
}
