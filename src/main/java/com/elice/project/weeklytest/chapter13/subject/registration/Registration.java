package com.elice.project.weeklytest.chapter13.subject.registration;

import com.elice.project.weeklytest.chapter13.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @Enumerated(EnumType.STRING)
    private RegisterStatus registerStatus = RegisterStatus.REGISTER_REQUEST;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 지시사항을 참고하여 코드를 작성해 보세요.
    @OneToMany(mappedBy = "registration", cascade = CascadeType.PERSIST)
    private List<RegistrationSubject> registrationSubjects = new ArrayList<>();


    public enum RegisterStatus {
        REGISTER_REQUEST(1, "수강 신청"),
        REGISTER_COMPLETE(2, "수강 신청 완료"),
        REGISTER_CANCEL(3, "수강 신청 취소"),
        ;

        @Getter
        private int step;

        @Getter
        private String description;

        RegisterStatus(int step, String description) {
            this.step = step;
            this.description = description;
        }
    }
}