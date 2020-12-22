package j.r.a.supermarket.model;

import j.r.a.supermarket.strategy.IPricingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PricingPartition {
    private Article article;
    private int quantity;
    private double price;
    private IPricingStrategy pricingStrategy;
}
