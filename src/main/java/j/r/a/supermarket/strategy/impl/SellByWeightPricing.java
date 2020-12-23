package j.r.a.supermarket.strategy.impl;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.Price;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.model.Quantity;
import j.r.a.supermarket.strategy.IPricingStrategy;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.List;

@EqualsAndHashCode
public class SellByWeightPricing implements IPricingStrategy {
    private static final String CODE = "CODE01";
    private static final Pair<Quantity, Price> DEFAULT_PRICE = Pair.of(new Quantity(1), new Price(0.00199));


    @Override
    public org.apache.commons.lang3.tuple.Pair<Quantity, Price> getInitialPrice() {
        return DEFAULT_PRICE;
    }

    @Override
    public String getStrategyCode() {
        return CODE;
    }

    @Override
    public List<PricingPartition> getPricingPartitions(Quantity quantity, Article article) {
        return Collections.singletonList(
                PricingPartition.builder()
                        .article(article)
                        .quantity(quantity)
                        .pricingStrategy(this)
                        .build()
        );
    }
}
