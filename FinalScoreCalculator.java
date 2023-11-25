import javax.swing.JOptionPane;

public class FinalScoreCalculator {
    public static void main(String[] args) {
        introductionMessage();
        String retryProgramRequest;

        do {
            int[] quarterScores = new int[5];

            for (int i = 0; i < quarterScores.length; i++) {
                quarterScores[i] = getQuarterScore(i + 1);
            }

            double average = calcAverage(quarterScores);
            presentResults(average);

            retryProgramRequest = retryProgram(average);
        } while (retryProgramRequest.equalsIgnoreCase("Yes"));

        System.exit(0);
    }

    public static void introductionMessage() {
        JOptionPane.showMessageDialog(null, "Welcome to Jim's Final Score Calculator!\n" +
        "Click \"OK\" to continue.");
    }

    public static int getQuarterScore(int quarter) {
        int quarterScore = 0;

        while (true) {
            String quarterScoreInput = JOptionPane.showInputDialog(null, "Enter your " + (quarter == 5 ? "Final Exam" : "Quarter " + quarter) + " Score:");

            if (quarterScoreInput == null) {
                JOptionPane.showMessageDialog(null, "Operation canceled. Exiting the program.\n" +
                "Thank you for using Jim's Final Score Calculator!");
                System.exit(0);
            }

            try {
                quarterScore = Integer.parseInt(quarterScoreInput);
                break;  // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a numerical value.");
            }
        }

        return quarterScore;
    }

    public static double calcAverage(int[] quarterScores) {
        int sum = 0;
        double average = 0;
        for (int i = 0; i < quarterScores.length; i++) {
            sum += quarterScores[i];
        }

        average = sum / quarterScores.length;
        return average;
    }

    public static void presentResults(double average) {
        JOptionPane.showMessageDialog(null, "Your final score is: " + average + "%.");
    }

    public static String retryProgram(double average) {
        int choice = JOptionPane.showConfirmDialog(null, "Would you like to retry the program?", "Retry Program", JOptionPane.YES_NO_OPTION);
    
        if (choice == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Thank you for using Jim's Final Score Calculator! Have a nice day.");
        }
        
        return (choice == JOptionPane.YES_OPTION) ? "Yes" : "No";
    }
}