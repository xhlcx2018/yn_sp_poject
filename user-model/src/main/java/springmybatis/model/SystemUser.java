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

@Setter
@Getter
@ToString
@Entity
@Table(name = "s_system_user")
public class SystemUser implements Serializable {
    @Id @Column(name = "id")
    private Long id;

    @Column(name = "party_address")
    private String partyAddress;

    @Column(name = "party_code")
    private String partyCode;

    @Column(name = "party_name")
    private String partyName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "active_flag")
    private Byte activeFlag;

    @Column(name = "eMail")
    private String email;

    @Column(name = "lock_flag")
    private Byte lockFlag;

    @Column(name = "login_ip")
    private String loginIp;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "manager_enabled_flag")
    private Byte managerEnabledFlag;

    @Column(name = "oa_Account")
    private String oaAccount;

    @Column(name = "order_Id")
    private Integer orderId;

    @Column(name = "login_password")
    private String loginPassword;

    @Column(name = "Password_Modify_Time")
    private Date passwordModifyTime;

    @Column(name = "relation_ID")
    private Date relationId;

    @Column(name = "role_enabled_flag")
    private Byte roleEnabledFlag;

    @Column(name = "u_Id")
    private String uId;

    @Column(name = "leaf_org_id")
    private Long leafOrgid;

    @Column(name = "Construct_Unit_id")
    private Long constructUnitId;

    @Column(name = "office_id")
    private Long officeId;

    public SystemUser(String loginName, String loginPassword) {
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public SystemUser() {
    }

    public SystemUser(Long id, String partyAddress, String partyCode, String partyName, String phone, Byte activeFlag, String email, Byte lockFlag, String loginIp, String loginName, Byte managerEnabledFlag, String oaAccount, Integer orderId, String loginPassword, Date passwordModifyTime, Date relationId, Byte roleEnabledFlag, String uId, Long leafOrgid, Long constructUnitId, Long officeId) {
        this.id = id;
        this.partyAddress = partyAddress;
        this.partyCode = partyCode;
        this.partyName = partyName;
        this.phone = phone;
        this.activeFlag = activeFlag;
        this.email = email;
        this.lockFlag = lockFlag;
        this.loginIp = loginIp;
        this.loginName = loginName;
        this.managerEnabledFlag = managerEnabledFlag;
        this.oaAccount = oaAccount;
        this.orderId = orderId;
        this.loginPassword = loginPassword;
        this.passwordModifyTime = passwordModifyTime;
        this.relationId = relationId;
        this.roleEnabledFlag = roleEnabledFlag;
        this.uId = uId;
        this.leafOrgid = leafOrgid;
        this.constructUnitId = constructUnitId;
        this.officeId = officeId;
    }
}
