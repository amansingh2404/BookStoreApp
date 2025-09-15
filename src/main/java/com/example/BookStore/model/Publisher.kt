package com.example.BookStore.model

import jakarta.persistence.*


@Entity
@Table(name = "publisher")
data class Publisher(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long,
    var name:String,
    @OneToMany(mappedBy = "publisher")
    var authors: MutableSet<Author>? = mutableSetOf<Author>(),
    @OneToMany(mappedBy = "publisher")
    var books: MutableSet<Book>? = mutableSetOf<Book>(),
    var address:String?,
    var contactDetails: String?

)
