package assignment4.ChainOfResponsibilityPattern;

public class Manager extends Approver {
    public void approveExpense(int amount) {
        if (amount < 1000) {
            System.out.println("Manager approved expense.");
        } else if (nextApprover != null) {
            nextApprover.approveExpense(amount);
        }
    }
}