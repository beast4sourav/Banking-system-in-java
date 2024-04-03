import java.util.*;
class trans {
    int count, total_amount;
    long withdrawal;
    void abc(long balance, int count, long total_amount, long withdrawal) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("1)Use ATM.\n2)Quit.\nEnter your choice:");
            int i = sc.nextInt();
            if (i == 1) {
                System.out.print("Enter the withdrawal amount:");
                withdrawal = sc.nextInt();
                this.count = count;
                total_amount = total_amount + withdrawal;
                try {
                    if (balance <= 1000) {
                        throw new Exception("Balance less than or equals to 1000\nBalance is:" + balance);
                    } else if (withdrawal > balance) {
                        throw new Exception("Your bank balance is less than withdrawal amount.");
                    } else if (withdrawal > 100000) {
                        throw new Exception("Cannot withdraw more than 1 lakh at a time.");
                    } else if (total_amount >= 100000) {
                        throw new Exception("Limit of 1 lakh per day exceeded.");
                    } else if (count >= 3) {
                        throw new Exception("Maximum number of transcations in a day exceeds.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    break;
                }
                balance = balance - withdrawal;
                System.out.println("Your current balance is:" + balance);
                count++;
            } else if (i == 2) {
                break;
            } else {
                System.out.println("Wrong Choice!!");
            }
        }
    }
}

public class Banking {
    public static void main(String[] args) {
        long balance;
        int count = 0, total_amount = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the balance:");
        balance = sc.nextLong();
        trans ob = new trans();
        ob.abc(balance, count, total_amount, 0);
    }
}