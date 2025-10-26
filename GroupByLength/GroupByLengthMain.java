import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLengthMain {

    public static void groupByLengthAndCountV1(List<String> words) {
        // Group words by length
        // Count words in each group
        // Print each group with its count
        words.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.counting()))
            .forEach((length, count) -> System.out.println(length + " -> " + count));
    }

    public static Map<Integer, Long> groupByLengthAndCountV2(List<String> words) {
        // Group words by length
        // Count words in each group
        // Print each group with its count
        return words.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));

            //.forEach((length, count) -> System.out.println(length + " -> " + count));
    }

    
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "in", "a", "frame", "hi");
        List<String> words1 = List.of("Hello", "World", "in", "a", "frame", "hi");
        groupByLengthAndCountV1(words);
        Map<Integer, Long> map1 = groupByLengthAndCountV2(words);
        System.out.println(map1);
        for(Map.Entry<Integer, Long> entry : map1.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        for(Long value : map1.values()){
            System.out.println("value"+ " -> " + value);
        }
        //System.out.println(groupByLengthAndCount(words));
    }
}