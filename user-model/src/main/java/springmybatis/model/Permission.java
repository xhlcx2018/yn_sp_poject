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
@Table(name = "s_xh_permission")
public class Permission {
    @Id
    @Column(name = "id") private Long id;
    @Column(name = "name") private String name;
    @Column(name = "des") private String des;
    @Column(name = "url") private String url;
    @Column(name = "pid") private String pid;
}
