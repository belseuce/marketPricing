package j.r.a.supermarket.processor.impl;

import com.google.common.collect.Lists;
import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.model.Quantity;
import j.r.a.supermarket.processor.ICostProcessor;
import j.r.a.supermarket.strategy.impl.DefaultByUnitPricing;
import j.r.a.supermarket.strategy.impl.PackOfThreePricing;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;

class SimpleCostProcessorTest {
    @Test
    public void should_give_0_65_for_one_defaultStrategy_Article() {
        ICostProcessor costProcessor = new SimpleCostProcessor();
        PricingPartition pricingPartition = PricingPartition.builder()
                .article(new Article("Orange", "fruit"))
                .quantity(new Quantity(1))
                .pricingStrategy(new DefaultByUnitPricing())
                .build();
        List<PricingPartition> pricingPartitions = Collections.singletonList(pricingPartition);
        Assert.assertThat(costProcessor.compute(pricingPartitions), is(0.65));
    }

    @Test
    public void should_give_0_for_empty_price_parttions() {
        ICostProcessor costProcessor = new SimpleCostProcessor();
        List<PricingPartition> pricingPartitions = Lists.newArrayList();
        Assert.assertThat(costProcessor.compute(pricingPartitions), is(0.0));
    }

    @Test
    public void should_give_1_65_for_4_pack_of_3_Articles() {
        ICostProcessor costProcessor = new SimpleCostProcessor();
        PricingPartition pricingPartition_1 = PricingPartition.builder()
                .article(new Article("Orange", "fruit"))
                .quantity(new Quantity(1))
                .pricingStrategy(new PackOfThreePricing())
                .build();
        PricingPartition pricingPartition_2 = PricingPartition.builder()
                .article(new Article("Orange", "fruit"))
                .quantity(new Quantity(1))
                .pricingStrategy(new DefaultByUnitPricing())
                .build();
        List<PricingPartition> pricingPartitions = Arrays.asList(pricingPartition_1, pricingPartition_2);
        Assert.assertThat(costProcessor.compute(pricingPartitions), is(1.65));
    }
}