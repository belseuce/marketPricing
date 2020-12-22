package j.r.a.supermarket.main;

import j.r.a.supermarket.model.Article;
import j.r.a.supermarket.model.Quantity;
import j.r.a.supermarket.strategy.impl.PackOfThreePricing;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MainAppTest {
    @Test
    public void should_give_price_for_1_pack_of_3_and_1_single_for_PackOfThreeStrategy() {
        MainApp app = new MainApp();
        Assert.assertThat(app.process(new Quantity(4), new Article("orange", "fruit"),
                new PackOfThreePricing()),
                Is.is(1.65));

    }

}