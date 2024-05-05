package hexlet.code.states.number;

import hexlet.code.states.State;

public class RangeState implements State<Integer> {
    private Integer min;
    private Integer max;

    public RangeState(Integer min, Integer max) {
        this.max = max;
        this.min = min;
    }

    @Override
    public boolean isValid(Integer value) {
        // условие слева проверяет было ли задано максимальное и минимальное значение
        return (max == null || min == null) || (min <= value && value <= max);
    }
}
