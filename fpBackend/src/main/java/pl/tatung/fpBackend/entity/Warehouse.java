package pl.tatung.fpBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWarehouse;
    @Column
    private String name;

    @ManyToMany(mappedBy = "warehouses")
    Set<Item> items;

}
