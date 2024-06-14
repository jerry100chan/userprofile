package org.it.user.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class Profile implements Serializable {
    @Serial
    private static final long serialVersionUID = 985947397875253938L;

    private String username;
    private Address address ;
    private String title;

    public Profile() {
        // do nothing
    }

    public Profile buildWithUserInfo(UserInfo userInfo) {
        this.username = userInfo.getUsername();
        this.address = userInfo.getAddress();
        return this;
    }

    public Profile buildWithPost(Post post) {
        this.title = post.getTitle();
        return this;
    }

}
