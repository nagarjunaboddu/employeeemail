package com.galvanize.employeeemail.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employeeId")
    private Long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private  String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<EmailAddress> emails;
}
