package hexlet.code.schemas;

import hexlet.code.states.State;

import java.util.List;

class Utils {
    // метод для обновления состояния на основе того, есть ли повтор или нет
    public static void updateState(List<State> states, State newState) {
        int index = findStateIndex(newState.getClass(), states);

        if (index != -1) {
            states.set(index, newState);
        } else {
            states.add(newState);
        }
    }

    // метод для поиска и замены предыдущего объекта новым
    // нужно для того, чтобы была возможность вызывать два одинаковых метода цепочкой
    private static int findStateIndex(Class<?> stateClass, List<State> states) {
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
