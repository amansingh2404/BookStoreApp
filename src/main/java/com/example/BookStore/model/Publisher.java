package com.example.BookStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "publisher")
    private Set<Author> authors ;
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;
    private String address;
    private String contactDetails;
}
