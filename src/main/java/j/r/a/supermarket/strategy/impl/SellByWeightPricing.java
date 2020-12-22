package j.r.a.supermarket.strategy.impl;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.strategy.IPricingStrategy;
import javafx.util.Pair;

import java.util.List;

public class SellByWeightPricing implements IPricingStrategy {
    private static final String CODE = "CODE01";
    Pair<Integer, Double> DEFAULT_PRICE = new Pair<>(1000,1.99);


    @Override
    public Pair<Integer, Double> getInitialPrice() {
        return DEFAULT_PRICE;
    }

    @Override
    public String getStrategyCode() {
        return CODE;
    }

    @Override
    public List<PricingPartition> getPricingPartitions(int quantity, Article article) {
        return null;
    }
}
