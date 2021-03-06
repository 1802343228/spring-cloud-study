package soft1851.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author crq
 * @version 1.0.0
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2020年09月10日 08:07:00
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
     * 学生序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkStudentId;

    /**
     * 学生姓名
     */
    @Column(nullable = false, length = 32)
    private String name;

    /**
     * 学生年龄     */
    @Column(nullable = false, length = 32)
    private int age;

}
