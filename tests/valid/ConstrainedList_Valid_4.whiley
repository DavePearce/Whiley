import println from whiley.lang.System
import * from whiley.lang.Int

function g(int x) => (int r)
ensures (r > 0) && (r < 125):
    return 1

function f(int x) => [i8]:
    return [g(x)]
