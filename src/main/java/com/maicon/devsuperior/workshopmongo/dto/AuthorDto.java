package com.maicon.devsuperior.workshopmongo.dto;

import java.io.Serializable;

import com.maicon.devsuperior.workshopmongo.domain.User;

public class AuthorDto implements Serializable {
    private static final long serialVersionUID = 1l;

    private String id;
    private String name;

    public AuthorDto() {}

    public AuthorDto(User user) {
        id = user.getId();
        name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AuthorDto other = (AuthorDto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
