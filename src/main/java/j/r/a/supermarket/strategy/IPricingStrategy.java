package j.r.a.supermarket.strategy;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.Price;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.model.Quantity;
import javafx.util.Pair;

import java.util.List;

public interface IPricingStrategy {
    Pair<Quantity, Price> getInitialPrice();
    String getStrategyCode();
    List<PricingPartition> getPricingPartitions(Quantity quantity, Article article);
}
