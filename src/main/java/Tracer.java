import soot.Value;

/**
 * Tracer class that holds an Expression Tree representing equations.
 * This can be used to track path conditions, arithmetic operations, etc.
 */
public class Tracer {

    // The equations accumulated on a specific path
    private java.util.List<ExprNode> equations;
    
    // The symbolic state mapping intermediate variables back to their input expressions
    private java.util.Map<String, ExprNode> symbolicState;

    public Tracer() {
        this.equations = new java.util.ArrayList<>();
        this.symbolicState = new java.util.HashMap<>();
    }

    public Tracer(java.util.List<ExprNode> equations, java.util.Map<String, ExprNode> symbolicState) {
        this.equations = new java.util.ArrayList<>(equations);
        this.symbolicState = new java.util.HashMap<>(symbolicState);
    }

    public java.util.List<ExprNode> getEquations() {
        return equations;
    }

    public void addEquation(ExprNode node) {
        if (!equations.contains(node)) {
            equations.add(node);
        }
    }

    public void putSymbol(String varName, ExprNode expr) {
        symbolicState.put(varName, expr);
    }

    public ExprNode resolveValue(Value v) {
        if (v instanceof soot.jimple.Constant) {
            return new ConstNode(v.toString());
        }
        String name = v.toString();
        if (symbolicState.containsKey(name)) {
            return symbolicState.get(name);
        }
        return new VarNode(v);
    }

    public void copy(Tracer other) {
        this.equations.clear();
        this.equations.addAll(other.equations);
        this.symbolicState.clear();
        this.symbolicState.putAll(other.symbolicState);
    }

    public void merge(Tracer other) {
        for (ExprNode expr : other.equations) {
            if (!this.equations.contains(expr)) {
                this.equations.add(expr);
            }
        }
        // For symbolic state, we could compute phi-functions or unions.
        // For simplicity in branch tracking, we just merge all states.
        for (java.util.Map.Entry<String, ExprNode> entry : other.symbolicState.entrySet()) {
            if (!this.symbolicState.containsKey(entry.getKey())) {
                this.symbolicState.put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public String toString() {
        return "Equations: " + equations.toString() + " | Symbols: " + symbolicState.toString();
    }

    // --- Expression Tree Node Definitions --- //

    /**
     * Base interface for all expression nodes.
     */
    public interface ExprNode {
        // Can be extended with methods like evaluate(), getVariables(), etc.
    }

    /**
     * Node representing a binary operation (e.g., +, -, *, /, ==, >, <)
     */
    public static class BinaryOpNode implements ExprNode {
        private String operator;
        private ExprNode left;
        private ExprNode right;

        public BinaryOpNode(String operator, ExprNode left, ExprNode right) {
            this.operator = operator;
            this.left = left;
            this.right = right;
        }

        public String getOperator() {
            return operator;
        }

        public ExprNode getLeft() {
            return left;
        }

        public ExprNode getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
        }
    }

    /**
     * Node representing a unary operation (e.g., !, -)
     */
    public static class UnaryOpNode implements ExprNode {
        private String operator;
        private ExprNode operand;

        public UnaryOpNode(String operator, ExprNode operand) {
            this.operator = operator;
            this.operand = operand;
        }

        public String getOperator() {
            return operator;
        }

        public ExprNode getOperand() {
            return operand;
        }

        @Override
        public String toString() {
            return operator + operand.toString();
        }
    }

    /**
     * Node representing a variable (e.g., local variables, parameters)
     */
    public static class VarNode implements ExprNode {
        private Value sootValue; // You can store the Soot Value directly
        private String name;

        public VarNode(Value sootValue) {
            this.sootValue = sootValue;
            this.name = sootValue.toString();
        }

        public VarNode(String name) {
            this.name = name;
        }

        public Value getSootValue() {
            return sootValue;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Node representing a constant value (e.g., integers, booleans, strings)
     */
    public static class ConstNode implements ExprNode {
        private String value;

        public ConstNode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}