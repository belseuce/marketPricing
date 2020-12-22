package j.r.a.supermarket.strategy.impl;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.model.Quantity;
import j.r.a.supermarket.strategy.IPricingStrategy;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PackOfTwoBonusPricingTest {
    private final Article article = new Article("orange", "fruit");

    @Test
    public void should_give_2_partitions_of_3_and_3_single_for_7_articles() {
        IPricingStrategy tripletStrategy = new PackOfTwoBonusPricing();
        IPricingStrategy singleStrategy = new DefaultByUnitPricing();
        PricingPartition bonusPartition = PricingPartition.builder()
                .article(article)
                .quantity(new Quantity(2))
                .pricingStrategy(tripletStrategy)
                .build();
        PricingPartition singlePartition = PricingPartition.builder()
                .article(article)
                .quantity(new Quantity(1))
                .pricingStrategy(singleStrategy)
                .build();
        List<PricingPartition> pricingPartitions = Arrays.asList(bonusPartition, singlePartition);
        Assert.assertTrue(pricingPartitions.stream().anyMatch(pricingPart -> pricingPart.getPricingStrategy().equals(tripletStrategy)));
        Assert.assertTrue(pricingPartitions.stream().anyMatch(pricingPart -> pricingPart.getPricingStrategy().equals(singleStrategy)));

        Assert.assertThat(tripletStrategy.getPricingPartitions(new Quantity(7), article), Is.is(pricingPartitions));
    }

}