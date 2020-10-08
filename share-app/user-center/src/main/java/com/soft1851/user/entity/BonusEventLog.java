package com.soft1851.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * @author crq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bonus_event_log")
public class BonusEventLog {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "value")
    private Integer value;

    @Column(name = "event")
    private String event;

    @Column(name = "create_time")
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


    @Column(name = "description")
    private String description;
}
