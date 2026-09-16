package com.jeffssousa.inventory_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_logistics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Logistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logisticsId;
    private Long orderId;
    private String Status;

}
