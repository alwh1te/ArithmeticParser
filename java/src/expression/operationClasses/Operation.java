package expression.operationClasses;

public interface Operation<T> {
    T evaluate(T x, T y, T z);
    T evaluate(T x);
}
