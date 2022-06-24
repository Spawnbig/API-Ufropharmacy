package cl.ufro.dci.ufropharmacy.models.sucursal;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class PagoSUC {
    @Id
    @GeneratedValue
    private long id;
    private String apiKey;
    private String commerceOrder;
    private String subject;
    private double amount;
    private String email;
    private int paymentMethod;
    private String urlConfirmation;
    private String urlReturn;
    private int timeout;
    private String merchantld;
    private String payment_currency;
    private String s;

    public PagoSUC() {
    }


    public PagoSUC(long id, String apiKey, String commerceOrder, String subject, double amount, String email, int paymentMethod, String urlConfirmation, String urlReturn, int timeout, String merchantld, String payment_currency, String s) {
        this.id = id;
        this.apiKey = apiKey;
        this.commerceOrder = commerceOrder;
        this.subject = subject;
        this.amount = amount;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.urlConfirmation = urlConfirmation;
        this.urlReturn = urlReturn;
        this.timeout = timeout;
        this.merchantld = merchantld;
        this.payment_currency = payment_currency;
        this.s = s;
    }
}
