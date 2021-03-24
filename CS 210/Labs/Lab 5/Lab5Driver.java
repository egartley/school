public class Lab5Driver {

    /**
     * Reads the files for AverageScore and prints out the data
     *
     * @param args
     */
    public static void main(String[] args) {
        AverageScore as = new AverageScore();
        // AverageScore as = new AverageScore("names.txt", "players.txt", "scores.txt");
        as.readInScores("scores.txt");
        as.readInTeams("names.txt");
        as.readTeamSizes("players.txt");
        as.processAverageScores();
    }

}
