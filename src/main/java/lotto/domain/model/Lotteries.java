package lotto.domain.model;

import lotto.constant.RankConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotteries {
    List<Lotto> lotteries = new ArrayList<>();

    public boolean add(Lotto lotto) {
        return this.lotteries.add(lotto);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public void showLotteries() {
        for (Lotto lotto : lotteries) {
            lotto.showNumbers();
        }
    }

    public Map<String, Integer> produceStatistics(WinningNumber winningNumber, BonusNumber bonusNumber) {
        Map<String, Integer> statics = new HashMap<>();
        statics.put(RankConstant.FIRST, 0);
        statics.put(RankConstant.SECOND, 0);
        statics.put(RankConstant.THIRD, 0);
        statics.put(RankConstant.FOURTH, 0);
        statics.put(RankConstant.FIFTH, 0);


        for (Lotto lotto : lotteries) {
            String result = lotto.calculateRank(winningNumber, bonusNumber);

            if (!result.equals(RankConstant.NONE)) statics.put(result, statics.get(result) + 1);
        }

        return statics;
    }
}
