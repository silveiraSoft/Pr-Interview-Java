import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainV2 {
    public static void main(String[] args) {
        Integer[] numbers = {10, 2, 13, 4, 5, 16, 7, 8, 9};

        List<Integer> list = Arrays.asList(numbers);
        Collections.reverse(list);
        Double result = list.stream().limit(Math.max(0, list.size()-3)).mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println(result);
        list.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
        System.out.println("-----");
        System.out.println(list.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList()).toString());
    

        //list.sort(Comparator.reverseOrder());
        /*
        list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        list.stream().mapToInt(Integer::intValue).sum();
        list.stream().mapToInt(Integer::intValue).max().getAsInt();
        list.stream().mapToInt(Integer::intValue).min().getAsInt();
        list.stream().mapToInt(Integer::intValue).count();
        list.stream().mapToInt(Integer::intValue).distinct().count(); 
        list.stream().mapToInt(Integer::intValue).sorted().toArray();
        list.stream().mapToInt(Integer::intValue).sorted().distinct().toArray();
        list.stream().mapToInt(Integer::intValue).sorted().distinct().max().getAsInt();
        list.stream().mapToInt(Integer::intValue).sorted().distinct().min().getAsInt();
        list.stream().mapToInt(Integer::intValue).sorted().distinct().average().getAsDouble();
        list.stream().mapToInt(Integer::intValue).sorted().distinct().sum();
        list.stream().mapToInt(Integer::intValue).sorted().distinct().count();
        list.stream().mapToInt(Integer::intValue).sorted().distinct().max().getAsInt();
        //sorter descendent
        list.stream().mapToInt(Integer::intValue).sorted().toArray();
        //sorter using comparator creating a lambda function not use reverseOrder
        list.stream().sorted((a, b) -> b.compareTo(a)).toArray();
        */


    
    }
}
