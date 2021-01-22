package org.mddarr.uirequestservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="refresh_token",schema = "users")
public class RefreshToken {
    @Id
    private String id;
    private String token;
    private Instant created_date;
}
