public class Shipping {
    private double shipping_rate = 20.50;

    public Shipping() {
    }

    public double rateCalculation(Game game){
        
    	
    	return (game.getPrice()*10 / 100 ) + shipping_rate;
    }
    public double getShipping_rate() {
        return shipping_rate;
    }

    public void setShipping_rate(double shipping_rate) {
        this.shipping_rate = shipping_rate;
    }
}
