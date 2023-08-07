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
@Table(name = "operation_type")
public class OperationTypeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5423716976328368254L;

    @Id
    @Column(name = "operation_id", nullable = false, updatable = false)
    private Long operationId;

    @Column(name = "description", nullable = false, updatable = false)
    private String description;

}
