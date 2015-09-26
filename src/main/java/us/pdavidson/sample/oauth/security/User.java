package us.pdavidson.sample.oauth.security;

import java.util.Objects;

public class User {

    private final Long userId;

    private final String username;

    private final String password;

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    private User(Builder builder) {
        userId = builder.userId;
        username = builder.username;
        password = builder.password;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long userId;
        private String username;
        private String password;

        private Builder() {
        }

        public Builder withUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("userId", userId)
                .add("username", username)
                .add("password", password)
                .toString();
    }
}
