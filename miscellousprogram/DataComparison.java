package miscellousprogram;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.text.DecimalFormat;

public class DataComparison {

    public static void main(String[] args) {
        try {
            Scanner group1 = new Scanner(new FileReader("miscellousprogram/group1.txt"));
            Scanner group2 = new Scanner(new FileReader("miscellousprogram/group2.txt"));

            PrintWriter outfile = new PrintWriter("miscellousprogram/student.txt");
            double avgGroup1 = 0;
            double avgGroup2 = 0;
            int numOfCourses = 0;

            outfile.println("Course ID Group No  Course Average");

            DecimalFormat df = new DecimalFormat("#.##");

            while (group1.hasNextLine() && group2.hasNextLine()) {
                String[] line1 = group1.nextLine().split("\\s+");
                String[] line2 = group2.nextLine().split("\\s+");
                String courseId1 = line1[0];
                String courseId2 = line2[0];

                if (!courseId1.equals(courseId2)) {
                    System.out.println("Data mismatch for course " + courseId1);
                    continue; // Skip to the next iteration
                }

                double avg1 = 0;
                double avg2 = 0;
                int count1 = 0;
                int count2 = 0;

                // Calculate average for group 1
                for (int i = 1; i < line1.length; i++) {
                    double score = Double.parseDouble(line1[i]);
                    if (score == -999) {
                        break; // Exit loop if score is -999
                    }
                    avg1 += score;
                    count1++;
                }

                // Calculate average for group 2
                for (int i = 1; i < line2.length; i++) {
                    double score = Double.parseDouble(line2[i]);
                    if (score == -999) {
                        break; // Exit loop if score is -999
                    }
                    avg2 += score;
                    count2++;
                }

                // Print course averages
                outfile.printf("%-9s %-9s %-15s%n", courseId1, "1",
                        count1 > 0 ? df.format(avg1 / count1) : "N/A");
                outfile.printf("%-9s %-9s %-15s%n", courseId2, "2",
                        count2 > 0 ? df.format(avg2 / count2) : "N/A");

                avgGroup1 += count1 > 0 ? avg1 / count1 : 0;
                avgGroup2 += count2 > 0 ? avg2 / count2 : 0;
                numOfCourses++;
            }

            double avg1 = avgGroup1 / numOfCourses;
            double avg2 = avgGroup2 / numOfCourses;
            outfile.println("Avg for group 1: " + df.format(avg1));
            outfile.println("Avg for group 2: " + df.format(avg2));

            group1.close();
            group2.close();
            outfile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
