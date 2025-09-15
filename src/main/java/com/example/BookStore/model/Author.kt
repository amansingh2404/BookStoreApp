package com.example.BookStore.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.*

@Entity
@Table(name = "Author")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var name: String,
    var contactDetails: String?,

    @ManyToMany(mappedBy = "authors")
    var books: MutableSet<Book>? = mutableSetOf<Book>(),

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    var publisher: Publisher?



)
