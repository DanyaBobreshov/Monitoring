package com.example.Monitoring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FourTable {
    private String division;
    private Long garantAll;
    private Long garantDate;
    private Long nonGarantAll;
    private Long nonGarantDate;
    private Long all;
}
