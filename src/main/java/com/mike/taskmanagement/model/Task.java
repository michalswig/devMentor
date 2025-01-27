package com.mike.taskmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
    private LocalDateTime deletedAt;

}

//public static boolean isPolishLetter(char c) {
//    Character.UnicodeBlock block = Character.UnicodeBlock.of(c);
//
//    return Character.isLetter(c) &&
//            (block == Character.UnicodeBlock.BASIC_LATIN ||
//                    block == Character.UnicodeBlock.LATIN_EXTENDED_A);
//}
