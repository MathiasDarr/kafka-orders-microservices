package org.mddarr.order.request.service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
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
