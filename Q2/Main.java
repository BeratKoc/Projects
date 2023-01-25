import java.util.Arrays;
public class Main{
    public static int[] main(int[] lines) {
        Arrays.sort(lines);
        for (int i = lines.length - 1; i >= 2; i--) {
            if (lines[i-2] + lines[i-1] > lines[i]) {
                return new int[] {lines[i-2], lines[i-1], lines[i]};
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] lines = {1, 2, 3, 4, 5, 10};
        int[] rslt = main(lines);
        for (int i : rslt) {
            System.out.print(i + " ");
        }
    }
}
