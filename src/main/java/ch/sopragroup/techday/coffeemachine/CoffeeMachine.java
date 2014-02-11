package ch.sopragroup.techday.coffeemachine;


/**
 * Coding Dojo. http://simcap.github.io/coffeemachine/
 * 
 * @author pescobar
 */
public class CoffeeMachine {
    
    private int creditAmountCts;

    public  String getCommand(Drink drink, int sugarNumb, boolean extraHot) {
        if (creditAmountCts < drink.getPriceInCts()) {
            return sendMessage("Need "+(drink.getPriceInCts() - creditAmountCts)+" cts");
        }
        if(extraHot){
            return drink.getCommand()+"h:"+(sugarNumb>0?sugarNumb:"")+":"+(sugarNumb>0?0:"");

        }
        return drink.getCommand()+":"+(sugarNumb>0?sugarNumb:"")+":"+(sugarNumb>0?0:"");
    }

    public String sendMessage(String message) {
        return "M:"+message;
    }

    public void addMoney(int addedAmountCts) {
        creditAmountCts += addedAmountCts;
    }

}
