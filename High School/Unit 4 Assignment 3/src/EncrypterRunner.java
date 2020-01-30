public class EncrypterRunner
{
   public static void main(String[] args)
   {
      Encrypter testEncrypter = new Encrypter(3, true);
      String inputWord = "hello";
      String encryptedWord = "";
      
      encryptedWord = testEncrypter.encrypt(inputWord);
      
      if (encryptedWord.equals("khoor")) 
      {
         System.out.println("Correct");
      }
      else 
      {
         System.out.println("Incorrect");
         System.out.println("Input word: " + inputWord);
         System.out.println("Your encrypted word: " + encryptedWord);
         System.out.println("Expected encrypted word: " + "khoor");
      }
   }
}
