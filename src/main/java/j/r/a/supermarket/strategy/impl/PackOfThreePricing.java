package j.r.a.supermarket.strategy.impl;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.Price;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.model.Quantity;
import j.r.a.supermarket.strategy.IPricingStrategy;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode
public class PackOfThreePricing implements IPricingStrategy {
    private static final String CODE = "CODE02";
    private static final Pair<Quantity, Price> DEFAULT_PRICE = Pair.of(new Quantity(3), new Price(1.00));

    @Override
    public Pair<Quantity, Price> getInitialPrice() {
        return DEFAULT_PRICE;
    }

    @Override
    public String getStrategyCode() {
        return CODE;
    }

    @Override
    public List<PricingPartition> getPricingPartitions(Quantity quantity, Article article) {

        int nbPacks = quantity.getValue() / 3;
        int singlePacks = quantity.getValue() % 3;

        return Arrays.asList(
                PricingPartition.builder()
                        .article(article)
                        .quantity(new Quantity(nbPacks))
                        .pricingStrategy(this)
                        .build(),
                PricingPartition.builder()
                        .article(article)
                        .quantity(new Quantity(singlePacks))
                        .pricingStrategy(DefaultByUnitPricing.create())
                        .build()
        );
    }
}
