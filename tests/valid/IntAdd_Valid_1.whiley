function swap2(int x, int y) -> (int r, int s)
    ensures true:
    assume x == 10
    assume y == 11
    x = 2 * x + y
    y = x - y
    x = x - y
    assert x == 11 && y == 2 * 10
    return x, y

public export method test():
    int a
    int b
    //
    (a,b) = swap2(10,11)
    //
    assume a == 11 && b == 2*10
    

