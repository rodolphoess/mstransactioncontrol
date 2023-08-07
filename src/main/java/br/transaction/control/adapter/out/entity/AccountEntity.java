package br.transaction.control.adapter.out.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "account")
public class AccountEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 916155131813537886L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_sequence")
    @SequenceGenerator(name = "account_id_sequence", sequenceName = "account_id_sequence", allocationSize = 1)
    @Column(name = "account_id", nullable = false, updatable = false)
    private Long accountId;

    @Column(name = "document_number", nullable = false)
    private String documentNumber;

    @Column(name = "account_type")
    private String accountType;

}
