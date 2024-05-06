package hexlet.code.states;

public final class RequiredState<T> implements State<T> {
    @Override
    public boolean isValid(T value) {
        return value != null;
    }
}
