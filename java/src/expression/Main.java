package expression;

import expression.exceptions.ParsingException;
import expression.generic.GenericOperation;
import expression.operationClasses.Operation;
import expression.parser.BaseParser;
import expression.types.*;

import java.util.Arrays;
import java.util.Map;

public class Main {
    // arguments of command line - target expression
    // first argument - mode, further - expression
    // Pred: args.length > 0 && args is parsable
    // Post: the parsed arithmetic expression
    public static void main(String[] args) {
        try {
            GenericOperation<?> mode = modes.get(args[0]);
            args = Arrays.copyOfRange(args, 1, args.length);
            String expression = String.join(" ", args);
            Operation<?> evaluatedExpr;
            evaluatedExpr = solver(mode, expression);
            System.out.println(evaluatedExpr.toString());
        } catch (ParsingException | ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }

    private static <T> Operation<T> solver(GenericOperation<T> mode, String expression) throws ParsingException {
        return new BaseParser<T>().parse(expression, mode);
    }

    private final static Map<String, GenericOperation<?>> modes = Map.of(
            "i", new IntegerType(),
            "d", new DoubleType(),
            "bi", new BigIntegerType(),
            "u", new IntegerUnCheckedType(),
            "b", new ByteUnCheckedType(),
            "bool", new BooleanType()
    );

}
