package j.r.a.supermarket.strategy.impl;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.model.Quantity;
import j.r.a.supermarket.strategy.IPricingStrategy;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SellByWeightPricingTest {
    private final Article article = new Article("Orange", "fruit");

    @Test
    public void should_give_2_partitions_for_8_articles() {
        IPricingStrategy weightStrategy = new SellByWeightPricing();
        PricingPartition fourOncesPart = PricingPartition.builder()
                .article(article)
                .quantity(new Quantity(2))
                .pricingStrategy(weightStrategy)
                .build();
        List<PricingPartition> pricingPartitions = Collections.singletonList(fourOncesPart);
        Assert.assertTrue(pricingPartitions.stream().anyMatch(pricingPart -> pricingPart.getPricingStrategy().equals(weightStrategy)));

        Assert.assertThat(weightStrategy.getPricingPartitions(new Quantity(8), article), Is.is(pricingPartitions));
    }
}