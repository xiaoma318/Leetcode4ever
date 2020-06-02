import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequency {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer,Integer> map = new HashMap<>();
    for(int x:nums){
      map.put(x,map.getOrDefault(x,0)+1);
    }
    List<Integer> list = map.entrySet().stream().sorted((a,b)->b.getValue()-a.getValue()).map(x->x.getKey()).limit(k).collect(
        Collectors.toList());
    int[] res = new int[k];

    for(int i=0;i<k;i++){
      res[i]=list.get(i);
    }

    return res;
  }
}
