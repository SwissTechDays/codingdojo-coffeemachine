package ch.sopragroup.techday.coffemachine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.sopragroup.techday.coffeemachine.CoffeeMachine;
import ch.sopragroup.techday.coffeemachine.Drink;
/**
 * Coding Dojo. http://simcap.github.io/coffeemachine/
 * 
 * @author pescobar
 */
public class CoffeeMachineTest {
    private CoffeeMachine machine ;
    
    @Before
    public void init(){
        machine = new CoffeeMachine();
    }

    @Test
    public void orderOneTeaWithOneSugar() {
        addALotOfMoney();
        Assert.assertEquals("T:1:0",machine.getCommand(Drink.TEA,1, false)); 
    }
    
    private void addALotOfMoney() {
        machine.addMoney(1000);
    }

    @Test
    public void orderOneChocolateWithoutSugar() {
        addALotOfMoney();
        Assert.assertEquals("H::",machine.getCommand(Drink.CHOCOLATE, 0, false));
    }
    
    @Test
    public void orderOneCoffeeWithTwoSugar() {
        machine.addMoney(100);
        Assert.assertEquals("C:2:0",machine.getCommand(Drink.COFFEE, 2, false));
    }
    
    @Test
    public void sendMessage() {
        Assert.assertEquals("M:message-content",machine.sendMessage("message-content"));
    }

    @Test
    public void orderOneCoffeeWithoutMoney() {
        Assert.assertEquals("M:Need 60 cts",machine.getCommand(Drink.COFFEE, 2, false));
    }

    @Test
    public void orderOneTeaWithoutMoney() {
        Assert.assertEquals("M:Need 40 cts",machine.getCommand(Drink.TEA, 0, false));
    }
    
    @Test
    public void orderOneChocolateWithoutMoney() {
        Assert.assertEquals("M:Need 50 cts",machine.getCommand(Drink.CHOCOLATE, 0, false));
    }
    
    @Test
    public void orderOneChocolateWithoutEnoughMoney() {
        machine.addMoney(40);
        Assert.assertEquals("M:Need 10 cts",machine.getCommand(Drink.CHOCOLATE, 0, false));
    }

    @Test
    public void orderOrangeJuiceWithoutEnoughMoney() {
        machine.addMoney(40);
        Assert.assertEquals("M:Need 20 cts",machine.getCommand(Drink.ORANGE, 0, false));
    }
    
    @Test
    public void orderOneOrangeJuice() {
        machine.addMoney(100);
        Assert.assertEquals("O::",machine.getCommand(Drink.ORANGE, 0, false));
    }

    @Test
    public void orderExtraHotCoffee() {
        machine.addMoney(100);
        Assert.assertEquals("Ch::",machine.getCommand(Drink.COFFEE, 0, true));
    }
    
    @Test
    public void orderExtraHotChocolateWithSugar() {
        machine.addMoney(100);
        Assert.assertEquals("Hh:1:0",machine.getCommand(Drink.CHOCOLATE, 1, true));
    }
    
    @Test
    public void orderExtraHotTeaWithTwoSugar() {
        machine.addMoney(100);
        Assert.assertEquals("Th:2:0",machine.getCommand(Drink.TEA, 2, true));
    }
    
    @Test
    public void orderExtraHotTeaWithTwoSugarWithNotEnoughMoney() {
        machine.addMoney(40);
        Assert.assertEquals("M:Need 10 cts",machine.getCommand(Drink.CHOCOLATE, 0, false));
    }

}
