import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrs =  new ArrayList<>();
        arrs.add("123");
        arrs.add("3456");
        arrs.add("12345");
        arrs.add("12");
        arrs.add("546465");
        arrs.add("654");
        arrs.add("54646");

        for (int i = 0; i < arrs.size(); ++i) {
            for (int j = arrs.size() - 1; j > i; --j) {
                if (arrs.get(i).contains(arrs.get(j))) {
                    arrs.remove(j);

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
