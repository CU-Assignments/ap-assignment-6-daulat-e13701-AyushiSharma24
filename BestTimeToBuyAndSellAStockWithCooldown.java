package Academics.AP2.Experiment6;

class BestTimeToBuyAndSellAStockWithCooldown {
    public int maxProfit(int[] prices) {
        int sell = 0, hold = Integer.MIN_VALUE, prevSell = 0, prevHold;
        for (int price : prices) {
            prevHold = hold;
            hold = Math.max(prevHold, prevSell - price);
            prevSell = sell;
            sell = Math.max(prevSell, prevHold + price);
        }
        return sell;
    }
}

