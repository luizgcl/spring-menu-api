package br.com.luizgcl.menu.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String name;

    @Column(unique = true)
    private String sku;

    @Column(unique = true)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category category;

    @Column
    private Double cost;

    @Column
    private Double price;

    @Column
    private LocalDateTime updatedAt;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;
}
