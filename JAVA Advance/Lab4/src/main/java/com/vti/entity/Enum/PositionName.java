package com.vti.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor@AllArgsConstructor
public enum PositionName {
    DEV("Dev"), TEST("Test"), MASTER("Master"), PM("PM");

    private String value;

    public static PositionName of(String value) {
        if (value == null) {
            return null;
        }

        for (PositionName name : PositionName.values()) {
            if (name.getValue().equals(value)) {
                return name;
            }
        }

        return null;
    }
}
