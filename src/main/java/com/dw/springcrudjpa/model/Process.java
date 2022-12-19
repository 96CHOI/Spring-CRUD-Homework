package com.dw.springcrudjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "process_list")
public class Process {

    @Id
    @Column
    private long processNum; // pk 과정번호

    @Column(length = 30)
    private String processName; // 과목명

    @Column
    private String processRoom; // 호실

    @Column
    private String processStartdate; // 과정기간시작

    @Column
    private String processEnddate; // 과정기간끝

    @Column
    private String teacherName; // 담당교사
}
