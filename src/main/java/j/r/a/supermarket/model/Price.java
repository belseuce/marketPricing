package j.r.a.supermarket.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @EqualsAndHashCode
public class Price {
    @Setter @Getter
    private double value;
}
