package com.galvanize.employeeemail.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private  String lastName;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "employee")
    private List<EmailAddress> emails;

}
