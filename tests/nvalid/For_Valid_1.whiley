import println from whiley.lang.System

method main(System.Console sys) => void:
    xs = [1, 2, 3]
    for st in xs:
        sys.out.println(Any.toString(st))