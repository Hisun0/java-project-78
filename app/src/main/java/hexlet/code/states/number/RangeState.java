package hexlet.code.states.number;

import hexlet.code.states.State;

public final class RangeState implements State<Integer> {
    private final Integer min;
    private final Integer max;

    public RangeState(Integer pMin, Integer pMax) {
        max = pMax;
        min = pMin;
    }

    @Override
    public boolean isValid(Integer value) {
        // условие слева проверяет было ли задано максимальное и минимальное значение
        return (max == null || min == null) || (min <= value && value <= max);
    }
}
