package com.example.Monitoring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Industrial {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String address;
    private String director;
    private String directorName;

    @OneToOne(fetch = FetchType.LAZY)
    private Performer contactManager;
}
