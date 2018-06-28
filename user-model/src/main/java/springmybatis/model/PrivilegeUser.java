package springmybatis.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "s_privilege_user")
public class PrivilegeUser implements Serializable {
    @Id @Column(name = "id") private Long id;
    @Column(name = "party_address") private String partyAddress;
    @Column(name = "party_code") private String partyCode;
    @Column(name = "party_desc") private String partyDesc;
    @Column(name = "party_name") private String partyName;
    @Column(name = "phone") private String phone;
    @Column(name = "active_flag") private Byte activeFlag;
    @Column(name = "eMail") private String eMail;
    @Column(name = "end_date") private Date endDate;
    @Column(name = "lock_flag") private Byte lockFlag;
    @Column(name = "login_ip") private String loginIp;
    @Column(name = "login_name") private String loginName;
    @Column(name = "manager_enabled_flag") private Byte managerEnabledFlag;
    @Column(name = "oa_Account") private String oaAccount;
    @Column(name = "order_Id") private Integer order_Id;
    @Column(name = "login_password") private String loginPassword;
    @Column(name = "Password_Modify_Time") private Date PasswordModifyTime;
    @Column(name = "relation_ID") private Integer relationID;
    @Column(name = "role_enabled_flag") private Byte roleEnabledFlag;
    @Column(name = "start_date") private Date startDate;
    @Column(name = "u_Id") private String u_Id;
    @Column(name = "update_date") private Date updateDate;
    @Column(name = "wrong_credential_times") private Integer wrongCredentialTimes;
    @Column(name = "system_user_id") private Long systemUserId;
    @Column(name = "job_id") private Long jobId;
    @Column(name = "position_id") private Long positionId;
    @Column(name = "department_id") private Long departmentId;
    @Column(name = "office_id") private Long officeId;
    @Column(name = "leaf_org_id") private Long leafOrgId;
    @Column(name = "Construct_Unit_id") private Long constructUnitId;
}
