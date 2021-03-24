import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageScore {

    /**
     * Contains the scores for the games
     */
    private ArrayList<Integer> scores = new ArrayList<>();
    /**
     * Contains the number of players on each team
     */
    private ArrayList<Integer> sizes = new ArrayList<>();
    /**
     * Contains the names of each team
     */
    private ArrayList<String> names = new ArrayList<>();

    /**
     * Creates an empty AverageScore instance
     */
    public AverageScore() {

    }

    /**
     * Reads in the three given files
     *
     * @param namesFile
     * @param playersFile
     * @param scoresFile
     */
    public AverageScore(String namesFile, String playersFile, String scoresFile) {
        readInTeams(namesFile);
        readInScores(scoresFile);
        readTeamSizes(playersFile);
    }

    /**
     * @param filename
     */
    public void readInTeams(String filename) {
        try {
            Scanner file = new Scanner(new File(filename));
            while (file.hasNext()) {
                names.add(file.next());
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, so there are no teams to process!");
        }
    }

    /**
     * @param filename
     */
    public void readInScores(String filename) {
        try {
            Scanner file = new Scanner(new File(filename));
            while (file.hasNextInt()) {
                scores.add(file.nextInt());
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, so there are no scores to process!");
        }
    }

    /**
     * @param filename
     */
    public void readTeamSizes(String filename) {
        try {
            Scanner file = new Scanner(new File(filename));
            while (file.hasNextInt()) {
                sizes.add(file.nextInt());
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, so there are no team sizes to process!");
        }
    }

    public void processAverageScores() {
        for (int i = 0; i < names.size(); i++) {
            try {
                if (sizes.get(i) == 0) {
                    throw new ArithmeticException(names.get(i) + " has no score!");
                } else if (scores.get(i) > 200) {
                    throw new ScoreTooHighException(names.get(i) + " has too high of a score! (" + scores.get(i) + ")");
                } else {
                    System.out.println("Team: " + names.get(i) + " Points per person: " + String.format("%.2f", (double) (scores.get(i)) / sizes.get(i)));
                }
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (ScoreTooHighException e) {
                System.out.println(e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println("Will not process anymore data");
                break;
            }
        }
    }

}
