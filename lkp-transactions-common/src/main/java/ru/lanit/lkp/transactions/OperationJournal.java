package ru.lanit.lkp.transactions;

import javax.persistence.*;

@Entity
@Table(name = "OPERATION_JOURNAL")
public class OperationJournal {
    @Column(name = "OP_JOURNAL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OPERATION_JOURNAL")
    @Id
    private Long id;

    @Column(name = "EVENT_NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
