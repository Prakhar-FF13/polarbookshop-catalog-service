package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;

public record Book (
        @Id
        Long id,

        @NotBlank(message = "The book ISBN must be defined")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "ISBN Format must be valid."
        )
        String isbn,

        @NotBlank(message = "Book title must be defined.")
        String title,

        @NotBlank(message = "Book author must be defined.")
        String author,

        @NotNull(message = "Book price must be defined.")
        @Positive(
                message = "The book price must be greater than 0."
        )
        Double price,

        String publisher,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,

        @Version
        int version
){
        public static Book of (
                String isbn, String title, String author, Double price, String publisher
        ) {
                return new Book(
                        null, isbn, title, author, price, publisher,
                        null, null, 0
                );
        }
}

