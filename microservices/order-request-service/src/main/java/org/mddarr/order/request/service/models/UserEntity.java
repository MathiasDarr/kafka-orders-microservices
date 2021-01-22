package org.mddarr.order.request.service.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users",schema = "users")
public class UserEntity {

    @Id
    private String userid;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Date update_ts;


}
