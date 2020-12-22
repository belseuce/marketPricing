package j.r.a.supermarket.strategy;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.PricingPartition;
import javafx.util.Pair;

import java.util.List;

public interface IPricingStrategy {
    Pair<Integer, Double> getInitialPrice();
    String getStrategyCode();
    List<PricingPartition> getPricingPartitions(int quantity, Article article);
}
