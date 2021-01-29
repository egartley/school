public class Problem3 {

    public static void main(String[] args) {
        printGrade(2);
        dessertType("apple");
    }

    public static void printGrade(int semesters) {
        switch (semesters) {
            case 1:
            case 2:
                System.out.println("Freshman");
                break;
            case 3:
            case 4:
                System.out.println("Sophomore");
                break;
            case 5:
            case 6:
                System.out.println("Junior");
                break;
            case 7:
            case 8:
                System.out.println("Senior");
                break;
            default:
                System.out.println("Incorrect semester number!");
                break;
        }
    }

    public static void dessertType(String food) {
        if (food.equals("apple") || food.equals("orange") || food.equals("pineapple")) {
            System.out.println("Healthy!");
        } else if (food.equals("pie") || food.equals("cookies")) {
            System.out.println("Less Healthy!");
        } else if (food.equals("creme brulee") || food.equals("baked alaska")) {
            System.out.println("Decadent!");
        } else {
            System.out.println("Not a dessert.");
        }
    }

}
