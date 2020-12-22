package j.r.a.supermarket.model;

import j.r.a.supermarket.strategy.IPricingStrategy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class PricingPartition {
    private Article article;
    private Quantity quantity;
    private IPricingStrategy pricingStrategy;
}
