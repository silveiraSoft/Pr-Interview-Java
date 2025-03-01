public class Main {
    public static String countRepetition(String strArg) {
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
    
    public static void main(String[] args) {
        System.out.println(countRepetition("aabbbcccc"));
    }


}
