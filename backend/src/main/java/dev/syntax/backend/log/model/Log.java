package dev.syntax.backend.log.model;

import dev.syntax.backend.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="log_id")
    private Long logId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name="log_type")
    private LogType logType;

    @Column(name="log_time")
    private LocalDateTime logTime;
    @Column(name="log_desc")
    private String logDesc;

    public Log(User user, LogType logType, LocalDateTime logTime, String logDesc) {
        this.user = user;
        this.logType = logType;
        this.logTime = logTime;
        this.logDesc = logDesc;
    }

}
