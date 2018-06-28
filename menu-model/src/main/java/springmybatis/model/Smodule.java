package springmybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@Entity
@Table(name = "s_module")
public class Smodule {

    @Column(name = "DTYPE")
    private String dtype;
    @Id
    @Column(name = "module_id")
    private Long moduleId;

    @Column(name = "isLeaf_flag")
    private Byte isLeafFlag;

    @Column(name = "isRoot_flag")
    private Byte isRootFlag;

    @Column(name = "active_flag")
    private Byte activeFlag;

    @Column(name = "module_code")
    private String moduleCode;

    @Column(name = "module_desc")
    private String moduleDesc;

    @Column(name = "module_index")
    private Integer moduleIndex;

    @Column(name = "delete_flag")
    private Byte deleteFlag;

    @Column(name = "module_level")
    private Integer moduleLevel;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "module_type")
    private String moduleType;

    @Column(name = "module_url")
    private String moduleUrl;

    @Column(name = "cooperation_url")
    private String cooperationUrl;

    @Column(name = "current_count_sql")
    private String currentCountSql;

    @Column(name = "height")
    private Integer height;

    @Column(name = "in_win")
    private Byte inWin;

    @Column(name = "total_count_sql")
    private String total_count_sql;

    @Column(name = "width")
    private Integer width;

    @Column(name = "icon_id")
    private Long iconId;

    @Column(name = "parent_module_id")
    private Long parentModuleId;
}
