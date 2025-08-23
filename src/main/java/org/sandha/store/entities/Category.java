package org.sandha.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Byte id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();

    public Category(byte id) {
        this.id = id;
    }
}