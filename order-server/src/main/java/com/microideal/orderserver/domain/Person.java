package com.microideal.orderserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * author microideal on 2018/5/24
 */
@Entity
@Data
@NoArgsConstructor
public class Person implements Serializable{
    private static final long serialVersionUID = 13121222222222L;
    @Id
    private Long id;
    private String name;
}
