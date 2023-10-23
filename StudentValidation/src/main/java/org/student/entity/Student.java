package org.student.entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
public class Student {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;
@NotBlank
@Size(min=3)
private String firstName;
@NotBlank
@Size(min=3)
private String lastName;
@NotNull
@Past
private LocalDate dob;
private int age;
@ElementCollection
@CollectionTable(name = "marks")
@MapKeyColumn(name = "subject")
@Column(name = "mark")
private Map<String, Integer> marks;
@NotNull
@Enumerated(EnumType.STRING)
private Section section;
@NotNull
@Enumerated(EnumType.STRING)
private Gender gender;
@Lob
private byte[] fileData;
private int totalMarks;
private double average;
private String result;
@PrePersist
@PreUpdate
private void calculateFields() {
    if (marks != null) {
        totalMarks = marks.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        average = totalMarks / (double) marks.size();
        result = marks.values().stream()
                .allMatch(mark -> mark >= 35) && average >= 35
                ? "Pass"
                : "Fail";
                age=Period.between(dob, LocalDate.now()).getYears();
                
    }
}
}
