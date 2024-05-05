package hexlet.code.schemas;

import hexlet.code.states.State;
import hexlet.code.states.string.ContainState;
import hexlet.code.states.string.MinLengthState;
import hexlet.code.states.string.RequiredState;

public class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        states.add(new RequiredState());
        return this;
    }

    public StringSchema contains(String pSymbols) {
        updateState(new ContainState(pSymbols));
        return this;
    }

    public StringSchema minLength(int pMinLength) {
        updateState(new MinLengthState(pMinLength));
        return this;
    }

    // TODO объединить логику методов updateState и findStateIndex
    // TODO пытался подвязать BaseSchema через отдельный класс адаптер, но не получилось
    // метод для обновления состояния на основе того, есть ли повтор или нет
    private void updateState(State newState) {
        int index = findStateIndex(newState.getClass());

        if (index != -1) {
            states.set(index, newState);
        } else {
            states.add(newState);
        }
    }

    // метод для поиска и замены предыдущего объекта новым
    // нужно для того, чтобы была возможность вызывать два одинаковых метода цепочкой
    private int findStateIndex(Class<?> stateClass) {
        int index = -1;
        for (int i = 0; i < states.size(); i++) {
            if (stateClass.isInstance(states.get(i))) {
                index = i;
                break;
            }
        }

        return index;
    }
}
