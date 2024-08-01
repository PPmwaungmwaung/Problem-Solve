import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Num25206 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> m = new HashMap<>();
        String rating;
        String[] input;
        double grade, gradeSum = 0.0, total = 0.0;

        m.put("A+", 4.5);
        m.put("A0", 4.0);
        m.put("B+", 3.5);
        m.put("B0", 3.0);
        m.put("C+", 2.5);
        m.put("C0", 2.0);
        m.put("D+", 1.5);
        m.put("D0", 1.0);
        m.put("F", 0.0);

        while(br.ready()) {
            input = br.readLine().split(" ");

            grade = Double.parseDouble(input[1]);
            rating = input[2];

            if(rating.equals("P")) { continue; }

            total += grade * m.get(rating);
            gradeSum += grade;
        }
        System.out.printf("%.6f", total / gradeSum);
    }
}
