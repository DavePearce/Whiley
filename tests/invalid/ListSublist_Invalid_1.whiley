import * from whiley.lang.*

method main(System.Console sys) => void:
    end = 1.2344
    list = [1, 2, 3]
    sublist = list[-1..end]
    sys.out.println(Any.toString(list))
    sys.out.println(Any.toString(sublist))
