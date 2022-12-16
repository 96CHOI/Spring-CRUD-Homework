package com.dw.springcrudjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_list")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long studentNum; // pk 학생번호

    @Column(length = 30)
    private String studentName; // 학생이름

    @Column
    private int studentAge; // 학생나이

    @Column
    private String studentPhone; // 학생 연락처

    @Column
    private String studentAddr; // 주소

    // @JoinColumn => member 테이블에 dept_id라는 컬럼(FK)생성
    @ManyToOne
    @JoinColumn(name = "processNum")
    private Process process;

}
