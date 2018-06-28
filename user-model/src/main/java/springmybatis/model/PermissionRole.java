package springmybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "s_xh_permission_role")
public class PermissionRole {
    @Id
    @Column(name = "id") private Long id;
    @Column(name = "role_id") private Long roleId;
    @Column(name = "permission_id") private Long permissionId;


}
