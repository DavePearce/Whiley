public export method test():
    //
    int x = 1
    int y = 2
    int a, int b = (y,x)
    //
    assert a == 2
    //
    assert b == 1
    //
    assert (2,1) == (a,b)
