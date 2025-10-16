import java.util.Arrays;
import java.util.stream.Collectors;

public class SortTime {
    public static void main(String[] args) {
        String[] input = new String[] {"10:20", "11:05", "09:09"};
        String[] output = Arrays.stream(input)
                .sorted((s1, s2) -> {
            String s1Suffix = s1.split(":")[1];
            String s2Suffix = s2.split(":")[1];
            return Integer.valueOf(s1Suffix).compareTo(Integer.valueOf(s2Suffix));
        }).toArray(String[]::new);
        System.out.println(Arrays.stream(output).collect(Collectors.toList()));
    }
}
