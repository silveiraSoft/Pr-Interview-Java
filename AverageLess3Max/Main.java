import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {10, 2, 13, 4, 5, 16, 7, 8, 9};
        /* 
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                //return a.compareTo(b);
                return b < a ? -1 : a==b ? 0 : 1;
            }
        };
        */
        Comparator<Integer> comp = (a, b) -> b < a ? -1 : a==b ? 0 : 1;
        
        Arrays.sort(numbers, comp);
        System.out.println(Arrays.toString(numbers));

        Arrays.sort(numbers, Comparator.reverseOrder());
        System.out.println(Arrays.toString(numbers));

        Arrays.sort(numbers, Collections.reverseOrder(Comparator.comparing(x->x)));
        System.out.println("este"+Arrays.toString(numbers));

        
        Arrays.sort(numbers);
        Integer[] numbersAux = Arrays.copyOfRange(numbers, 0, numbers.length - 3);
       
        System.out.println(Arrays.toString(numbersAux));
        //System.out.println(numbersAux.toString());
        //calculate average of numbersAux using stream

        double average = Arrays.stream(numbersAux).mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println(average);

        Integer sum = 0;
        for (int i = 0; i < numbersAux.length; i++) {
            sum += numbersAux[i];
        }
        average = sum / numbersAux.length;
        System.out.println(average);
    }
}
