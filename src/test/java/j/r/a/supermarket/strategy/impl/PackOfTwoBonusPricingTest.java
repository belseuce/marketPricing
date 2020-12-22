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

class PackOfTwoBonusPricingTest {
    private final Article article = new Article("Orange", "fruit");

    @Test
    public void should_give_2_partitions_for_6_articles() {
        IPricingStrategy bonusStrategy = new PackOfTwoBonusPricing();
        PricingPartition bonusPartitions = PricingPartition.builder()
                .article(article)
                .quantity(new Quantity(2))
                .pricingStrategy(bonusStrategy)
                .build();
        List<PricingPartition> pricingPartitions = Collections.singletonList(bonusPartitions);
        Assert.assertTrue(pricingPartitions.stream().allMatch(pricingPart -> pricingPart.getPricingStrategy().equals(bonusStrategy)));

        Assert.assertThat(bonusStrategy.getPricingPartitions(new Quantity(6), article), Is.is(pricingPartitions));
    }

}