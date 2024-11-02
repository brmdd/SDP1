package assignment4.ChainOfResponsibilityPattern;

public class TeamLead extends Approver {
    public void approveExpense(int amount) {
        if (amount < 500) {
            System.out.println("Team Lead approved expense.");
        } else if (nextApprover != null) {
            nextApprover.approveExpense(amount);
        }
    }
}