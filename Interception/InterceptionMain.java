import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

public class InterceptionMain {
     public static String FindIntersectionV1(String[] strArr) {
    Set<Integer> set1 = Arrays.stream(strArr[0].split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());
    //System.out.print(set1.toString());
    Set<Integer> set2 = Arrays.stream(strArr[1].split(", "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet());
    set1.retainAll(set2);
    return set1.stream().sorted((a,b)->Integer.compare(a,b)).map(String::valueOf).collect(Collectors.joining(", "));
    //return strArr[0];
  }

  public static String FindIntersectionV2(String[] strArr) {
        return Arrays.asList(strArr[0].split(", "))
                            .stream()
                            .filter(num -> Arrays.asList(strArr[1].split(", "))
                                            .stream()
                                            //.map(Integer::parseInt)
                                            .collect(Collectors.toList())
                                            .contains(num))
                            .map(Integer::parseInt)
                            //.sorted((a,b)->Integer.compare(b,a))
                            //.sorted((a,b)-> b > a ? 1: -1)
                            .sorted((a,b)-> b-a)
                            .map(String::valueOf)
                            .collect(Collectors.joining(", "));
  }

  public static String FindIntersectionV3(String[] strArr) {
     
    List<Integer> list1 = Arrays.stream(strArr[0].split(", "))
    .map(Integer::parseInt)
    .collect(Collectors.toList());

    //System.out.print(set1.toString());
    Set<Integer> set2 = Arrays.stream(strArr[1].split(", "))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
    //list1.retainAll(set2);
    //convert set to list 
    List<Integer> list2 = set2.stream().collect(Collectors.toList());
    //list1.retainAll(list2);
    //convert set to list using ArrayList
    //return list1.stream().sorted((a,b)->Integer.compare(a,b)).map(String::valueOf).collect(Collectors.joining(", "));
    
    List<String> list2String = set2.stream().map(String::valueOf).collect(Collectors.toList());
    List<String> list3 = new ArrayList<>(list2String); 
    List<String> list4 = Arrays.stream(strArr[0].split(", "))
      .collect(Collectors.toList()); 
    list3.retainAll(list4); 
    return String.join(", ", list3);  
    
    
  }

  public static void main (String[] args) {  

    // keep this function call here     
    //Scanner s = new Scanner(System.in);
    //System.out.print(FindIntersectionV1(s.nextLine())); 
    //String input = s.nextLine();
    String[] strInput =  new String[] {"1, 3, 4, 5, 7, 13", "1, 2, 4, 5, 13, 15"};
    //System.out.print(FindIntersectionV1(strInput)); 
    //System.out.print(FindIntersectionV2(strInput)); 
    System.out.print(FindIntersectionV3(strInput)); 
  }
}