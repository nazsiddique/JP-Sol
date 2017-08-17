package model;

public enum InstructionTypeEnum {

    LEAK(0),
    BUY(1),
    SELL(2);

    private Integer value;

    /**
     * Creates a value type
     *
     * @param value Numeric value of the value type
     */
    InstructionTypeEnum(Integer value) {
        this.value = value;
    }

    /**
     * Returns the value type for the specified string value
     * Always returns an object
     *
     * @param value Numeric value of the value type
     * @return model.InstructionTypeEnum
     */
    public static InstructionTypeEnum get(String value) {
        return Common.isBlank(value) ? LEAK : get(Common.parseInt(value));
    }

    /**
     * Returns the data type for the specified numeric value
     * Always returns an object
     *
     * @param value Numeric value of the mode
     * @return model.InstructionTypeEnum
     */
    public static InstructionTypeEnum get(Integer value) {
        if (value == null) {
            return LEAK;
        }
        else {
            for (InstructionTypeEnum mode : values()) {
                if (mode.value != null && mode.value.intValue() == value.intValue()) {
                    return mode;
                }
            }
        }
        return LEAK;
    }

    /**
     * Returns the numeric value of the data type - can be null
     *
     * @return Numeric value
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Returns true if the data type is the same as this value
     *
     * @param valueType Value Type or null
     * @return True if the values are equivalent
     */
    public boolean is(InstructionTypeEnum valueType) {
        if (valueType == null && value == null) {
            return true;
        }
        else if (valueType != null && valueType.value == null && value == null) {
            return true;
        }
        else if (valueType != null && valueType.value != null && value != null && valueType.value.equals(value)) {
            return true;
        }
        else {
            return false;
        }
    }


}
