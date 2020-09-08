public class NowCodemaxProfit {

    /**
     * 题目描述 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
     * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。
     * 请你设计一个算法来计算可以获得的最大收益。
     */
    public static int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int i = 0; i < prices.length; i++){
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, prices[i] + buy);
        }
        return sell;
    }

    public static void main (String[] args){
        int[] prices = {2, 4, 1};
        System.out.println(maxProfit(prices));
    }
}