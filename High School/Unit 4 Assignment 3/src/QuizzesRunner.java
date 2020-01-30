public class QuizzesRunner 
{
   public static void main(String[] args) 
   {
      int [] scoresArray = {80,  95, 75, 12, 54, 
                            100, 86, 48, 89, 23, 
                            48,  79, 88, 91, 94, 
                            93,  46, 85, 73, 57, 
                            65,  62, 75, 84, 97, 
                            13,  34, 77, 88, 86};
      
      int [] mondayScoresAns =  {80, 100, 48, 93, 65, 13};
      int [] tuesdayScoresAns = {95, 86, 79, 46, 62, 34};
      
      Quizzes testQuizzes = new Quizzes();
      String bestDayForQuizzes = "";
      boolean correctAns = false;
      int i = 0;
      
      // Check Part A for Monday
      correctAns = true;
      int [] testScores = testQuizzes.getDayScores(scoresArray, "Monday");      
      if (testScores.length == mondayScoresAns.length) 
      {
         for (i = 0; i < mondayScoresAns.length; ++i) 
         {
            if (testScores[i] != mondayScoresAns[i]) 
            {
               correctAns = false;
            }
         }
      }
      else 
      {
         correctAns = false;
      }
      if (correctAns) 
      {
         System.out.println("Part A correct for Monday");
      }
      else 
      {
         System.out.println("Part A incorrect for Monday");
      }
      // Check Part A for Tuesday
      correctAns = true;
      testScores = testQuizzes.getDayScores(scoresArray, "Tuesday");
      if (testScores.length == tuesdayScoresAns.length) 
      {
         for (i = 0; i < tuesdayScoresAns.length; ++i) 
         {
            if (testScores[i] != tuesdayScoresAns[i]) 
            {
               correctAns = false;
            }
         }
      }
      else 
      {
         correctAns = false;
      }
      if (correctAns) 
      {
         System.out.println("Part A correct for Tuesday");
      }
      else 
      {
         System.out.println("Part A incorrect for Tuesday");
      }
      // Check Part B
      bestDayForQuizzes = testQuizzes.bestDay(scoresArray);
      if (bestDayForQuizzes.equals("Wednesday")) 
      {
         System.out.println("Part B correct");
      }
      else 
      {
         System.out.println("Part B incorrect");
      }
   }
}
