package j.r.a.supermarket.processor.impl;

import j.r.a.supermarket.model.PricingPartition;
import j.r.a.supermarket.processor.ICostProcessor;

import java.util.List;

public class SimpleCostProcessor implements ICostProcessor {
    @Override
    public double compute(List<PricingPartition> pricingPartitions) {
        return pricingPartitions.stream().mapToDouble(
                pricingPartition -> pricingPartition.getQuantity().getValue() *
                        pricingPartition.getPricingStrategy().getInitialPrice().getValue().getValue()).sum();
    }
}
