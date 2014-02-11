package ch.sopragroup.techday.coffeemachine;

public enum Drink {
    TEA("T", 40), CHOCOLATE("H", 50), COFFEE("C", 60), ORANGE("O",60);
    
    private String command;
    private int priceInCts;


    private Drink(String command, int priceInCts) {
        this.command = command;
        this.priceInCts = priceInCts;
    }
    
    public String getCommand() {
        return command;
    }

    public int getPriceInCts() {
        return priceInCts;
    }
    
}
