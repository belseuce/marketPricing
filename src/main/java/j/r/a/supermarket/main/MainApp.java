package j.r.a.supermarket.main;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.model.Quantity;
import j.r.a.supermarket.processor.impl.SimpleCostProcessor;
import j.r.a.supermarket.strategy.IPricingStrategy;

import java.util.List;

public class MainApp {
    public double process(Quantity quantity, Article article, IPricingStrategy pricingStrategy) {
        List<PricingPartition> partitions = pricingStrategy.getPricingPartitions(quantity, article);
        return new SimpleCostProcessor().compute(partitions);
    }
}
