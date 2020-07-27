package org.bitbucket.nullptr7.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@Builder
@Table(name = "EMPLOYEE")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String name;

    @NotNull
    private Double salary;

    @NotNull
    @ManyToOne(fetch = EAGER, optional = false)
    private Address address;
}
