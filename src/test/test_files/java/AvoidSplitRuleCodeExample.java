@SuppressWarnings("all")
class Example {
    String string = "004-034556";
    String[] parts = string.split("-"); // Noncompliant
    String part1 = parts[0];
    String part2 = parts[1];
}