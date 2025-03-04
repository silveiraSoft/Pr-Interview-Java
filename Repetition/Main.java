
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Main {
    public static String countRepeatedConsecutive(String strArg) {
        char[] charArray = strArg.toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if(count == 1)
                sb.append(charArray[i]);
            if (i + 1 < charArray.length && charArray[i] == charArray[i + 1]) {
                count++;
            } else {
                sb.append("-"+count);
                if(i < charArray.length-1)
                    sb.append(",");     
                count = 1;
            }
        }
        return sb.toString();
    }

    public static String countRepeatedConsecutiveV2(String strArg) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArg.length(); i++) {
            if(count == 1)
                sb.append(strArg.charAt(i));
            if (i + 1 < strArg.length() && strArg.charAt(i) == strArg.charAt(i + 1)) {
                count++;
            } else {
                sb.append("-"+count);
                if(i < strArg.length() -1)
                    sb.append(",");     
                count = 1;
            }
        }
        return sb.toString();

    }

    public static String countAllRepeated(String strArg) {
        
        Set<String> set2 = new TreeSet<>((a,b)->{
            //return Integer.compare(Integer.parseInt(a.split("-")[1]), Integer.parseInt(b.split("-")[1]));
            return Character.compare(a.charAt(0), b.charAt(0));
            /* 
            int result = Integer.compare(Integer.parseInt(a.split("-")[1]), Integer.parseInt(b.split("-")[1]));
             
            if(result == 0){
                return a.compareTo(b);
            }
            return result * -1;
            

            //return result == 0 ? a.compareTo(b) : result * -1;
            */

        });
        //Set<String> set1 = new HashSet<>();
        strArg.chars().mapToObj(c -> (char) c).distinct().forEach(c -> {
            int countChar = (int) strArg.chars().filter(ch -> ch == c).count();
            set2.add(c + "-" + countChar);
        });

        //return set2.stream().collect(Collectors.joining(", "));
        return String.join(", ", set2);
    }

    public static String countAllRepeatedV2(String strArg) {
        List<String> list = new ArrayList<>();
        
        // First collect all unique characters while preserving order
        List<Character> uniqueChars = strArg.chars()
            .mapToObj(c -> (char) c)
            .distinct()
            .collect(Collectors.toList());
        
        // Count occurrences for each character
        for (Character c : uniqueChars) {
            int countChar = (int) strArg.chars()
                //.mapToObj(ch -> (char) ch)
                .filter(ch -> ch == c)
                .count();
            list.add(c + "-" + countChar);
        }
        
        // Sort the list by character (optional - remove if you want original order)
        list.sort((a, b) -> Character.compare(a.charAt(0), b.charAt(0)));
        
        return String.join(", ", list);
    }
    
    
    public static void main(String[] args) {
        System.out.println(countRepeatedConsecutive("aabbbcccc"));
        System.out.println(countRepeatedConsecutiveV2("aabbbccccO"));
        System.out.println(countAllRepeated("aabbbcccco"));
        //System.out.println(countAllRepeatedV2("aabbbcccco"));
    }
}
