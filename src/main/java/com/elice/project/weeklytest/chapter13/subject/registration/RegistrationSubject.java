package com.elice.project.weeklytest.chapter13.subject.registration;

import com.elice.project.weeklytest.chapter13.subject.entity.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RegistrationSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationSubjectId;

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_id")
    private Registration registration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private int price;
}