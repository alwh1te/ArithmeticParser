package expression.operationClasses;

import expression.generic.GenericOperation;

import java.util.Objects;

public abstract class AbstractUnaryOperation<T> implements Operation<T> {

    protected final Operation<T> value;
    protected final GenericOperation<T> type;

    protected AbstractUnaryOperation(Operation<T> value, GenericOperation<T> type) {
        this.value = value;
        this.type = type;
    }

    protected abstract String getOperator();

    @Override
    public String toString() {
        return getOperator() + value + ")";
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractUnaryOperation<?> that = (AbstractUnaryOperation<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
