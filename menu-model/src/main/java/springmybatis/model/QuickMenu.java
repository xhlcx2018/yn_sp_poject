package springmybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "b_quick_menu")
public class QuickMenu {
    /**
     * 唯一标识
     */

    @Id
    @Column(name = "id")
    protected Long id;

    /*
     * 人员
     */
    @Column(name = "user_id")
    private Integer user_id;

    /*
     * 菜单
     */
    @JoinColumn(name = "module_id")
    private Integer module_id;

    /**
     * 优先级
     */
    @Column
    private Integer priority;
}