string f([int] a) requires |a| > 0:
     a[0] = 5
     return str(a)

void System::main([string] args):
     b = [1,2,3]
     out.println(str(b))
     out.println(f(b))
     out.println(str(b))
