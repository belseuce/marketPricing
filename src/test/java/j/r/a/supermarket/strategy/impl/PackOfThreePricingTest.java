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

class PackOfThreePricingTest {

    private final Article article = new Article("orange", "fruit");

    @Test
    public void should_give_1_pack_of_3_and_1_single_partitions_for_4_articles() {
        IPricingStrategy packStrategy = new PackOfThreePricing();
        IPricingStrategy singleStrategy = new DefaultByUnitPricing();
        PricingPartition packPart = PricingPartition.builder()
                .article(article)
                .quantity(new Quantity(1))
                .pricingStrategy(packStrategy)
                .build();
        PricingPartition singlePart = PricingPartition.builder()
                .article(article)
                .quantity(new Quantity(1))
                .pricingStrategy(singleStrategy)
                .build();
        List<PricingPartition> pricingPartitions = Arrays.asList(packPart, singlePart);
        Assert.assertTrue(pricingPartitions.stream().anyMatch(pricingPart -> pricingPart.getPricingStrategy().equals(singleStrategy)));
        Assert.assertTrue(pricingPartitions.stream().anyMatch(pricingPart -> pricingPart.getPricingStrategy().equals(packStrategy)));

        Assert.assertThat(packStrategy.getPricingPartitions(new Quantity(4), article), Is.is(pricingPartitions));
    }

    @Test
    public void should_give_1_pack_of_3_and_2_single_partitions_for_5_articles() {
        IPricingStrategy packStrategy = new PackOfThreePricing();
        IPricingStrategy singleStrategy = new DefaultByUnitPricing();
        PricingPartition singlePart = PricingPartition.builder()
                .article(article)
                .quantity(new Quantity(2))
                .pricingStrategy(singleStrategy)
                .build();
        PricingPartition packPart = PricingPartition.builder()
                .article(article)
                .quantity(new Quantity(1))
                .pricingStrategy(packStrategy)
                .build();
        List<PricingPartition> pricingPartitions = Arrays.asList(packPart, singlePart);
        Assert.assertTrue(pricingPartitions.stream().anyMatch(pricingPart -> pricingPart.getPricingStrategy().equals(singleStrategy)));
        Assert.assertTrue(pricingPartitions.stream().anyMatch(pricingPart -> pricingPart.getPricingStrategy().equals(packStrategy)));

        Assert.assertThat(packStrategy.getPricingPartitions(new Quantity(5), article), Is.is(pricingPartitions));
    }
}