package WeeklyMatch.week100;

/**
 * @author panda
 */
public class DistMoney {
    public int distMoney(int money, int children) {
        // 若儿童数量为1，直接返回所有钱数
        if (children == 1 ) {
            return money == 8 ? 1:-1;
        }
        // 若总钱数小于等于儿童数量，则每个儿童分配1美元即可
        if (money <= children) {
            return -1;
        }
        // 计算除去已经分配的钱数后，还剩下多少钱需要分配给儿童
        int remainingMoney = money - children;
        // 初始化可以获得8美元的儿童数量为0
        int maxNumOfEightDollarChildren = 0;
        // 遍历每个儿童可以获得的金额，从1美元一直到3美元
        for (int i = 1; i <= 3; i++) {
            // 计算分配i美元给每个儿童后，还剩下多少钱需要分配给其他儿童
            int remainingMoneyPerChild = remainingMoney / i;
            // 若剩余的钱不足以分配给其他儿童，则跳出循环
            if (remainingMoneyPerChild < children - 1) {
                break;
            }
            // 若剩余的钱刚好可以分配给其他儿童，则计算可以获得8美元的儿童数量
            if (remainingMoneyPerChild == children - 1) {
                maxNumOfEightDollarChildren = Math.max(maxNumOfEightDollarChildren, i - 1);
            }
            // 若剩余的钱能够分配给其他儿童且有剩余，则计算可以获得8美元的儿童数量
            if (remainingMoneyPerChild > children - 1) {
                int numOfEightDollarChildren = Math.min(remainingMoneyPerChild - children + 1, i - 1);
                maxNumOfEightDollarChildren = Math.max(maxNumOfEightDollarChildren, numOfEightDollarChildren);
            }
        }
        // 若存在可以获得8美元的儿童，则返回数量；否则返回-1
        return maxNumOfEightDollarChildren > 0 ? maxNumOfEightDollarChildren : -1;
    }
}
