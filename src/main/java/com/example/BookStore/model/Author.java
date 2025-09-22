package com.example.BookStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Author")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
    private String name;
   private String  contactDetails;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
