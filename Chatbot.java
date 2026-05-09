import java.util.*;

public class Chatbot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Chatbot: Hello! How can I help you?");

        while (true) {
            System.out.print("You: ");
            input = sc.nextLine().toLowerCase();

            if (input.contains("hello") || input.contains("hi")) {
                System.out.println("Chatbot: Hello! Welcome!");
            } 
            else if (input.contains("price")) {
                System.out.println("Chatbot: Prices start from Rs.500.");
            } 
            else if (input.contains("order")) {
                System.out.println("Chatbot: Your order will be delivered in 3-5 days.");
            } 
            else if (input.contains("bye")) {
                System.out.println("Chatbot: Thank you! Visit again.");
                break;
            } 
            else {
                System.out.println("Chatbot: Sorry, I didn't understand.");
            }
        }
    }
}
