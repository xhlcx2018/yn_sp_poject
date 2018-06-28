package springmybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "s_role")
public class Role implements Serializable{

        @Id @Column(name = "ROLE_ID") private Long roleId;

        @Column(name = "active_flag") private Byte activeFlag;

        @Column(name = "description") private String description;

        @Column(name = "is_TeamRole") private Byte isTeamRole;

        @Column(name = "role_name") private String roleName;

        @Column(name = "role_code") private String roleCode;

        @Column(name = "role_type_id") private Long role_type_id;

        @Column(name = "construct_unit_id") private Long constructUnitId;

        @Column(name = "org_type_id") private Long orgTypeId;

        @Column(name = "operator_id") private Long operatorId;

    }
