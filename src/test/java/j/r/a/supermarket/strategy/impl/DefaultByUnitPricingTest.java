package j.r.a.supermarket.strategy.impl;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.model.Quantity;
import j.r.a.supermarket.strategy.IPricingStrategy;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class DefaultByUnitPricingTest {
    private final Article article = new Article("Orange", "fruit");

    @Test
    public void should_give_1_partion_for_3_single_articles() {
        IPricingStrategy pricingStrategy = new DefaultByUnitPricing();
        PricingPartition pricingPartition = PricingPartition.builder()
                .article(article)
                .quantity(new Quantity(3))
                .pricingStrategy(pricingStrategy)
                .build();
        List<PricingPartition> pricingPartitions = Collections.singletonList(pricingPartition);
        Assert.assertTrue(pricingPartitions.stream().allMatch(pricingPart -> pricingPart.getPricingStrategy().equals(pricingStrategy)));
        Assert.assertThat(pricingStrategy.getPricingPartitions(new Quantity(3), article), Is.is(pricingPartitions));
    }

}