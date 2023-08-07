package br.transaction.control.adapter.out.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "transaction")
public class TransactionEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4154262495403372826L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_sequence")
    @SequenceGenerator(name = "transaction_id_sequence", sequenceName = "transaction_id_sequence", allocationSize = 1)
    @Column(name = "transaction_id", nullable = false, updatable = false)
    private Long transactionId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @Column(name = "operation_id")
    private Long operationType;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "event_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime eventDate;

}
