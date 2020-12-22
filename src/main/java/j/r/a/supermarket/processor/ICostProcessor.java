package j.r.a.supermarket.processor;

import j.r.a.supermarket.model.PricingPartition;

import java.util.List;

public interface ICostProcessor {
    double process(List<PricingPartition> pricingPartitions);
}
