package assignment4.ChainOfResponsibilityPattern;



public class Director extends Approver {
    public void approveExpense(int amount) {
        if (amount < 5000) {
            System.out.println("Director approved expense.");
        } else if (nextApprover != null) {
            nextApprover.approveExpense(amount);
        }
    }
}
