package WeeklyMatch;
import java.util.*;

public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        String[] res = new String[n];
        Map< Integer,String> map = new HashMap<>();
        Arrays.sort(heights);


        for(int i = 0;i < n;++i){
            map.put(heights[i],names[i]);
        }

        map = sortMap(map);
        for (int i = 0; i < n; i++) {
            res[i] = map.get(heights[i]);
        }

        System.out.println(map);
        for (int i = 0; i < n; ++i) {
            System.out.println(res[i]);
        }
       return res;
    }


    public <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortMap(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
//            int compare = (o1.getValue()).compareTo(o2.getValue());
            int compare = (o1.getKey()).compareTo(o2.getKey());
            return -compare;
            //return compare;
        });

        Map<K, V> returnMap = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            returnMap.put(entry.getKey(), entry.getValue());
        }
        return returnMap;
    }

    public static void main(String[] args) {
       String[] names = {"Mary", "John", "Emma"};
       int[] heights = {180,165,170};

       SortPeople s = new SortPeople();
       s.sortPeople(names,heights);

    }


}
