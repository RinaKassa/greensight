@SuppressWarnings("all")
class TooManyLines {
    private static final int A = 10;
    private static final int B = 10;
    private static final int C = 10;
    private static final int D = 10;
    private static final int E = 10;
    private static final int F = 10;
    private static final int G = 10;
    private static final int H = 10;
    private static final int I = 10; // Noncompliant {{THRESHOLD SURPASSED}}
    private static final int J = 10;
}
