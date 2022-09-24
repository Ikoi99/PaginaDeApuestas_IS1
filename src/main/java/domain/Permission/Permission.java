package domain.Permission;

import javax.persistence.Embeddable;

@Embeddable
public class Permission {
    private String value;
    public Permission(String permission){
        this.value =permission;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
