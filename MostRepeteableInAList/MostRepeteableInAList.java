import java.util.*;
import java.util.stream.Collectors;


public class MostRepeteableInAList {
    public static String mostRepeteableInAList(List<String> words) {
        return words.stream()
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    public static Optional<Map.Entry<Integer, Long>> mostRepeteableInAListV3(List<Integer> words) {
        return words.stream()
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue());
            //.map(Map.Entry::getKey);
            //.orElse(null);
    }

    public static Optional<Map.Entry<Integer, Long>> mostRepeteableInAListV2(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n->n, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .findFirst();
                //.orElse(null);
    }

    public static Optional<Map.Entry<Integer, Long>> mostRepeteableInAListV4(List<Integer> numbers) {
        return numbers.stream().distinct()
                .map(n -> Map.entry(n, numbers.stream().filter(x -> x.equals(n)).count()))
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .findFirst();
    }

    public static void main1(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "in", "a", "frame", "hi");
        System.out.println(mostRepeteableInAList(words));
        List<Integer> numbers = Arrays.asList(12, 45, 7, 89, 23, 45, 7, 12, 99, 34, 56, 7, 45, 18, 7, 62, 45, 29, 12, 73, 7, 81, 45, 19, 33, 12, 7, 45, 90, 61, 45, 7, 27, 45, 88, 12, 7, 39, 45, 55, 12, 7, 46, 72, 7, 45, 11, 12, 7, 30);
        System.out.println(mostRepeteableInAListV3(numbers).map(r->{
            return r.getKey() +"-"+ r.getValue();
        }).orElse("Error"));
        System.out.println(mostRepeteableInAListV2(numbers).map(r->{
            return r.getKey() +"-"+ r.getValue();
        }).orElse("Error"));
    }

    public static void main2(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "in", "a", "frame", "hi");
        Map<String, Long> result = words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        Optional<Map.Entry<String, Long>> maxEntry = result.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (maxEntry.isPresent()) {
            System.out.println(maxEntry.get().getKey() + " - " + maxEntry.get().getValue());
        } else {
            System.out.println("No max entry found");
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "in", "a", "frame", "hi");
        System.out.println(mostRepeteableInAList(words));
        List<Integer> numbers = Arrays.asList(12, 45, 7, 89, 23, 45, 7, 12, 99, 34, 56, 7, 45, 18, 7, 62, 45, 29, 12, 73, 7, 81, 45, 19, 33, 12, 7, 45, 90, 61, 45, 7, 27, 45, 88, 12, 7, 39, 45, 55, 12, 7, 46, 72, 7, 45, 11, 12, 7, 30);
        System.out.println(mostRepeteableInAListV2(numbers).map(r->{
            return r.getKey() +"-"+ r.getValue();
        }).orElse("Error"));
        
        System.out.println(mostRepeteableInAListV3(numbers).map(r->{
            return r.getKey() +"-"+ r.getValue();
        }).orElse("Error"));
        System.out.println(mostRepeteableInAListV4(numbers).map(r->{
            return r.getKey() +"-"+ r.getValue();
        }).orElse("Error"));
    }

    
    /* 
    public static void main2(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 45, 7, 89, 23, 45, 7, 12, 99, 34, 56, 7, 45, 18, 7, 62, 45, 29, 12, 73, 7, 81, 45, 19, 33, 12, 7, 45, 90, 61, 45, 7, 27, 45, 88, 12, 7, 39, 45, 55, 12, 7, 46, 72, 7, 45, 11, 12, 7, 30);
        Map.Entry<Integer, Long> result = numbers.stream()
                .collect(Collectors.groupingBy(n->n, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .findFirst()
                .orElse(null);
                //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        System.out.println(result.getKey() + " - " + result.getValue());

    }
    */
    
}
