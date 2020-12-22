package j.r.a.supermarket.strategy.impl;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.strategy.IPricingStrategy;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;

public class defaultByUnitPricing implements IPricingStrategy {
    private static final String CODE = "CODE00";
    private static String defaultUnit = "pce";
    Pair<Integer, Double> DEFAULT_PRICE = new Pair<>(1, 0.65);

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
        return Collections.emptyList();
    }
}
