package com.soft1851.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


/**
 * @author crq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Integer id;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "content")
    private String content;
    @Column(name = "show_flag")
    private Boolean showFlag;
}
