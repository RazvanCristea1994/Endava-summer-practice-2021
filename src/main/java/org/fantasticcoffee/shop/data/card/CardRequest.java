package org.fantasticcoffee.shop.data.card;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
public class CardRequest {

    @Pattern(regexp = "[\\d]{16}", message = "Card number length invalid")
    private final String cardNumber;
    @NotNull(message = "Card holder name requested")
    @Pattern(regexp = "^[a-zA-Z '-]+$", message = "Wrong name format")
    private final String cardHolderName;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private final LocalDate expiry;
    @Pattern(regexp = "[\\d]{3}", message = "Civ length must be 3")
    private final String civ;

    public CardRequest(String cardNumber,
                       String cardHolderName, LocalDate expiry,
                       String civ) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiry = expiry;
        this.civ = civ;
    }
}