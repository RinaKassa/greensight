@SuppressWarnings("all")
class AvoidComplexExpressionRuleExample {
    void myMethod () {
        int i,j,k = 0;

        if(i>j){}
        if(i<j && i<k){}
        if(i<j && i>k || k<j){}
        if(i<j || i>k && k<j){}
        if(i>j && i>k && k<j && j>k){}
        if(i>j && i>k && k<j && j>k && j<i){} // Noncompliant
        if(i>j || i>k || k<j || j>k || j<i){} // Noncompliant
        if((i<j && i>k) || ((k<j && k>i) || i>k)){} // Noncompliant
        boolean resi = i > j && j > k || i < j && !(k == j);
        boolean resj = i > j && j > k || i < j && !(k == j) || k > j; // Noncompliant
        while((i<j && i>k) || i>k){}
        while((i<j && i>k) || ((k<j && k>i) || i>k)){} // Noncompliant
    }
}