package com.recoder.project1.auth.dto;

import com.recoder.project1.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class SessionUser implements Serializable {
    private String nickname;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
