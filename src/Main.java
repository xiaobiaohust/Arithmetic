import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> arrs = Arrays.asList("123", "3456", "12345", "12", "654", "54646");
        for (int i = 0; i < arrs.size(); ++i) {
            for (int j = arrs.size() - 1; j > i; --j) {
                if (arrs.get(i).contains(arrs.get(j))) {
                    arrs.remove(arrs.get(j));

                } else if (arrs.get(j).contains(arrs.get(i))) {
                    arrs.remove(arrs.get(i));
                }
            }
        }

        for (String arr : arrs) {
            System.out.println(arr);
        }
    }
}
