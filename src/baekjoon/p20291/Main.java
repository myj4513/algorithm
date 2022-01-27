package baekjoon.p20291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Map<String, List<String>> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), ".");
            String fileName = st.nextToken();
            String extension = st.nextToken();

            if (map.containsKey(extension)) {
                List<String> fileNames = map.get(extension);
                fileNames.add(fileName);
            } else {
                List<String> fileNames = new ArrayList<>();
                fileNames.add(fileName);
                map.put(extension, fileNames);
            }
        }

        for (String extension : map.keySet()) {
            sb.append(extension + " " + map.get(extension).size()+"\n");
        }
        System.out.println(sb);
    }
}
